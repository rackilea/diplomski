public class Indian
{
    public static void main(String[] args) throws Exception
    {
        Configuration configuration = new Configuration();
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
        configuration.setUseGrammar(false);

        LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);

        recognizer.startRecognition(true);
        System.out.println("Start speaking. \n");
        SpeechResult result;
        long timer = 0;

        while (timer < 2 * 60 * 1000)
        {
            result = recognizer.getResult();
            if (result != null)
            {
                System.out.print("You said: ");
                for (WordResult word : result.getWords())
                {
                    if (!word.isFiller())
                        System.out.print(word.getWord() + " ");
                }
                System.out.println();
            }
            else
            {
                System.out.println("I can't hear what you said.\n");
            }
        }
        recognizer.stopRecognition();
    }
}