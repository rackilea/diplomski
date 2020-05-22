textToSpeech = new TextToSpeech(context.getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                 // for speak code goes here 



                } else {
                    Toast.makeText(context, "tts_failed Error code "+status, Toast.LENGTH_LONG).show();
                    if(status == -1) // 
                    {
                        // this is will open play store if use have not install or disable google text to speach 
                        try {
                            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.google.android.tts")));
                        } catch (android.content.ActivityNotFoundException anfe) {
                            context.  startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.tts" )));
                        }
                    }



}