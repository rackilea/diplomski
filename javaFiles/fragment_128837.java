private clickCounter=0;

...


//simonClickListener used for button presses during players turn
    class simonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            ImageView simonIMG = (ImageView) findViewById(R.id.simon);
            TextView currentScoreTV = (TextView) findViewById(R.id.current_score_tv);

            Log.i("DEBUG", "playerTurnBool = true, running simonClickListener loop.");


            switch (v.getId()) {
                case R.id.blue_button:
                    Log.i("DEBUG", "Blue button clicked.");
                    playerArray[clickCounter] = 1;
                    simonIMG.setImageResource(R.drawable.blue_lit);
                    playSound(a_blue_sound_id);
                    break;
                case R.id.yellow_button:
                    Log.i("DEBUG", "Yellow button clicked.");
                    playerArray[clickCounter] = 2;
                    simonIMG.setImageResource(R.drawable.yellow_lit);
                    playSound(b_yellow_sound_id);
                    break;
                case R.id.green_button:
                    Log.i("DEBUG", "Green button clicked.");
                    playerArray[clickCounter] = 3;
                    simonIMG.setImageResource(R.drawable.green_lit);
                    playSound(c_green_sound_id);
                    break;
                case R.id.red_button:
                    Log.i("DEBUG", "Red button clicked.");
                    playerArray[clickCounter] = 4;
                    simonIMG.setImageResource(R.drawable.red_lit);
                    break;
            }

            if (playerArray[clickCounter] != simon.getSimonCode()[clickCounter]) {
                Log.i("DEBUG", "Player lost");
                gameRunning = false;
                Toast.makeText(GameScreen.this, "You Lose!", Toast.LENGTH_SHORT);
            }else if(playerArray[clickCounter] == simon.getSimonCode()[clickCounter]){
                score+=1;
                currentScoreTV.setText(""+score); // no score first time around and button click is registered twice second time around
                Log.i("DEBUG", "Score increased. score = " + score);
            }

            clickCounter++:

            if (clickCounter >= guessesAllowed {
                playerTurnBool = false;
                simonsTurnBool = true;
                Log.i("DEBUG", "Player turn complete.");
            }


            if (gameRunning && simonsTurnBool == true) {
                guessesAllowed++;
                Log.i("DEBUG", "Increasing guessesAllowed and starting simonTurn().");
                simonTurn();
                clickCounter = 0;
            }
        }
    }