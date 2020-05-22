public class TranscriberDemoGrammar {

    public static void main(String[] args) throws Exception {
        System.out.println("Loading models...");

        Configuration configuration = new Configuration();

        configuration.setAcousticModelPath("file:en-us-8khz");
        configuration.setDictionaryPath("cmu07a.dic");
        configuration.setGrammarPath("file:./");
        configuration.setGrammarName("digits");
        configuration.setUseGrammar(true);

        StreamSpeechRecognizer recognizer =
            new StreamSpeechRecognizer(configuration);
        InputStream stream = new FileInputStream(new File("file.wav"));
        recognizer.startRecognition(stream);

        SpeechResult result;

        while ((result = recognizer.getResult()) != null) {

            System.out.format("Hypothesis: %s\n",
                              result.getHypothesis());
            }

        recognizer.stopRecognition();
    }
}