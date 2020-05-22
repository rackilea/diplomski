public static void speakOut(String message) {

    System.out.println("Message is: " + message);

    tts.speak(message, TextToSpeech.QUEUE_ADD, null);

}