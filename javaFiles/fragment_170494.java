private static final float WAIT_TIME = 5f;
float time = 0;

public void update(float deltaTime) {
    time += deltaTime;
    if (time >= WAIT_TIME) {
        // TODO: Perform your action here

        // Reset timer (not set to 0)
        time -= WAIT_TIME;
    }
}