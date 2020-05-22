if((TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished)==4) &&
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - 
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))==55)
            {

            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 500 milliseconds
            v.vibrate(500);
            }