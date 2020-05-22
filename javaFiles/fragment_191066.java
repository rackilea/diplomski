startStop.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int frequency = Integer.parseInt(frequencyInput.getText().toString());
            displayFrequency.setText(String.valueOf(frequency));
            sineWave.setSine(frequency);
            squareWave.setSquareWave(frequency);
            sawWave.setSawWave(frequency);
            boolean on = sine.isChecked();
            boolean sqOn = square.isChecked();
            boolean sawOn = saw.isChecked();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (on) {
                        sineWave.start();
                    } else if (sqOn) {
                        squareWave.start();
                    } else if (sawOn) {
                        sawWave.start();
                    }
                    break;    
                case MotionEvent.ACTION_UP:
                    if (!on) {
                        sineWave.stop();
                    }
                    if (!sqOn) {
                        squareWave.stop();
                    }
                    if (!sawOn) {
                        sawWave.stop();
                    }
                    break;
                default:
                    return false;
            }
            return true;
        }
    });