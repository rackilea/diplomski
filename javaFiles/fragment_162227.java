private void setupButtonActions(final ImageButton button, final int tint_up, final int tint_down) {
    //create button listeners and tints
    button.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            if (isPlayerTurn) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    button.getBackground().setColorFilter(tint_down, PorterDuff.Mode.MULTIPLY);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    button.getBackground().setColorFilter(tint_up, PorterDuff.Mode.MULTIPLY);
                }

                //Enter correct sequence value
                int val = 4;

                if (button == mTopLeft) {
                    val = 0;
                } else if (button == mTopRight) {
                    val = 1;
                } else if (button == mBotLeft) {
                    val = 2;
                } else if (button == mBotRight) {
                    val = 3;
                }

                playSeq.add(val);
                if(playSeq.size() < level) {
                     //Check for correct input
                     if (playSeq.size() > 0 && (playSeq.get(playSeq.size()-1) != compSeq.get(playSeq.size()-1))) {
                           isRunning = false;
                           isPlayerTurn = false;
                     }

                 }else{
                     playSeq.clear();
                     compSeq.clear();
                     isPlayerTurn = false;
                     onComputerDown();
                 }

            }

            return false;
        }
    });