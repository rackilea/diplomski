private int loopCount = 0;
private int pressCount = 0;

public void button(View v) { /* Runs when button is clicked */
    if (loopCount < 4){
        pressCount++;

        if (pressCount == 3){
            pressCount = 0;
            loopCount++;
            stop();
        }
    }
}