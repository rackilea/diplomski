choice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (choice.getText().equals(mAnswer)) {
                        try {
            mp.reset();
            AssetFileDescriptor afd;
            afd = getAssets().openFd("your_sound.mp3");
            mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            mp.prepare();
            mp.start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
                        updateScore();
                        updateQuestion();
                        Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();



                    } else {
                        Toast.makeText(QuizActivity.this, "Wrong... Try again!", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(QuizActivity.this, Menu2.class);
                        intent.putExtra("score", mScore); // pass score to Menu2
                        startActivity(intent);
                    }
                }
            });