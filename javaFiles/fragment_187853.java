VoiceDirectory vd = new KevinVoiceDirectory();
Voice voices =  vd.getVoices();
Voice helloVoice = voices;
helloVoice.allocate();
/*
* Synthesize speech.
*/
helloVoice.speak("Thank you for giving me a voice. "
+ "I'm so glad to say hello to this world.");
/*
* Clean up and leave.
*/
helloVoice.deallocate();