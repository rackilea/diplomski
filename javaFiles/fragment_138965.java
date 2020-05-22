public void next() {
        ImageButton btnNext = (ImageButton) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        temp = temp + 1;
                        try {
                            playSong(mAudioPath[temp]);
                        } catch (Exception er) {
                            er.printStackTrace();
                        }

                    }
                }
        );
    }