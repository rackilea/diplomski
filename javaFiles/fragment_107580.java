System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        if (myTTS.textToSpeechIsInitialized) {  // <--- add this line
             myTTS.speakOut("salam","dj");
        } else { 
             // try again later 
        }