public String getTranslatedText (String text1){
        Translate.setClientId("CLIENT ID");
        Translate.setClientSecret("CLIENT SECRET");
        String translatedText = "";
        Log.e("Checkpoint", "getTranslatedText() was called");
        try {

            // Should check it first
            Log.d("TEXT", "text is = " + text);
            switch (text) {
               case "English":
               ...
               defaut:
               ...
            }
        }
        ..
      }