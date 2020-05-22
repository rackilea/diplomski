onCompletionDialog = new Dialog(this);
        onCompletionDialog .requestWindowFeature(Window.FEATURE_NO_TITLE);
        onCompletionDialog .setContentView(R.layout.songcompletedialog);
        completedSongName = (TextView)onCompletionDialog.findViewById(R.id.completedSongName);
        playAnotherSong   = (Button)onCompletionDialog.findViewById(R.id.buttonPlayAnotherSong);
        replayCurrentsong = (Button) onCompletionDialog.findViewById(R.id.buttonPlayAgain);
        tstBtn = (Button)onCompletionDialog.findViewById(R.id.testBtn);