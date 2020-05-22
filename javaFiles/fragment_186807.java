@Override
public void run() {
    while (true) {
        try {
            Thread.sleep(SLEEP_TIME); // constant for the sleep time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // again note that the array has been renamed
        for (GameObject gameObject : gameObjectArray) {
            gameObject.move();  // this is all that needs to be called here
        }
        repaint();
    }
}