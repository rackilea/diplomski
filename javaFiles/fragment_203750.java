public static void playMusic(Context context, RelativeLayout normalLayout) {

int chosenTheme = Utils.loadPreferences(context, "theme", 0);

switch(chosenTheme){
    case 0 : normalMP = MediaPlayer.create(context, R.raw.darude_sandstorm);
             normalMP.setLooping(true);
             normalMP.start();
             normalMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { //Handling the resource release part

            @Override
            public void onCompletion(MediaPlayer mp)
            {
                mp.release();
                normalLayout.setEnabled(true); //Enable the button after sound has played
            }
        });
             break;
   //write case statements for other five cases

    }
}