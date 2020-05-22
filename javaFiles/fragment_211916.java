MediaPlayer myMediaPlayer;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Media Player setup
        myMediaPlayer = new MediaPlayer();
        myMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        myMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.reset();
            }
        });

        //Buttons
        Button button1 = view.findViewById(R.id.button_record1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.record1);
            }
        });
        Button button2 = view.findViewById(R.id.button_record2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.record2);
            }
        });
    }

    void playSound(int rawResId) {
        try {
            AssetFileDescriptor afd = getContext().getResources().openRawResourceFd(rawResId);
            if (afd != null) {
                myMediaPlayer.reset();
                myMediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                myMediaPlayer.prepareAsync();
            }
        } catch (Exception ex) {
            Log.d("MediaPLayer", "playSound exception: " + ex.getMessage());
        }
    }