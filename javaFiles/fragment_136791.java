@Component
@Service(IntentHandler.class)
public class ExampleSimpleIntentHandlerService implements IntentHandler {

    private static final String SLOT_NAME = "mySlot";
    private static final String INTENT_NAME = "myIntent";

    @Override
    public boolean supportsIntent(String intentName) {
        return INTENT_NAME.equals(intentName);
    }

    @Override
    public SpeechletResponse handleIntent(final SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {

        final IntentRequest request = requestEnvelope.getRequest();
        final Intent intent = request.getIntent();
        final Slot slot = intent.getSlot(SLOT_NAME);

        final String responseMessage;
        if (slot == null) {
            responseMessage = format(
                    "I got your request, but there is no slot %",
                    SLOT_NAME);
        } else {
            responseMessage = format(
                    "I got your request. Slot value is %s. Thanks!",
                    slot.getValue());
        }
        return newTellResponse(responseMessage);
    }

    private SpeechletResponse newTellResponse(final String text) {
        return SpeechletResponse.newTellResponse(newPlainTextOutputSpeech(text));
    }

    private PlainTextOutputSpeech newPlainTextOutputSpeech(final String text) {
        final PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(text);
        return speech;
    }
}