String doei = "doei";
String[] greetings = { "hallo", "hi", "yow" };
mostLikelyThingHeard = mostLikelyThingHeard.toLowerCase();
boolean found = false;

for (String strings : greetings) {
    if (mostLikelyThingHeard.contains(strings)) {
        tts.speak("Hey nice to see you!",
            TextToSpeech.QUEUE_FLUSH, null);
        found = true;
        break;
    }
} 
if (!found) { 
    if (mostLikelyThingHeard.equals(doei)) {
        tts.speak("Okay tot de volgende keer!", TextToSpeech.QUEUE_FLUSH, null);
    } else {
        tts.speak("Ik begrijp niet wat je bedoeld met "
          + mostLikelyThingHeard
          + " probeer het anders te verwoorden.",
          TextToSpeech.QUEUE_FLUSH, null);
    }
}