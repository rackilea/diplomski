public void userGuessNumber() {
     boolean win = false
     [...] // Options Menu Code - timer should not increment for this section       
     long guessNumberStarted = System.currentTimeMillis();
     int timeElapsed = 0;
     while (!win) {
        if (guess == number) {
            win = true;
            timeElapsed = (int)(System.currentTimeMillis() - guessNumberStarted) / 1000;
        }
     }
 [...] // Do some code 
 }