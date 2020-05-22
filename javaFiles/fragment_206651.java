while (true)
{
    long startTime = System.currentTimeMillis();

    fenster.repaint();

    long remaining= 20 - (System.currentTimeMillis() - startTime);
    Thread.sleep(remaining - 2); // adds up to 18 ms since start if repaint took 10ms

    remaining= 20 - (System.currentTimeMillis() - startTime);
    Thread.sleep(remaining); // should be 1-2ms
}