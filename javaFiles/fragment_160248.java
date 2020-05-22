@RestController
@RequestMapping(value = "/twilio", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public class TwilioCallbackController {
  @PostMapping
  public String handleCallback(TwilioWebhook request) {
     log.info("received callback for callId {}", request.getCallSid()) 
     // rest of the controller.
  }
}