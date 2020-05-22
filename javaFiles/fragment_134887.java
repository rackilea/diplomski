mp.setOnCompletionListener(new OnCompletionListener() {

        @Override
        public void onCompletion(MediaPlayer mp) {
            mp.stop();

        }

        });

choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice.getText().equals(mAnswer)) {
                    mp.prepare();
                    mp.start();


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