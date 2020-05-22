int count = 0; // Declare it here or in your constructor

public void update() {
    int x = 0;
    if (checkPaddle() == true) {
        count++;
    }
    if (count % 2 == 0) {
        x = -7;
    } else {
        x = 7;
    }
    paddleLocation.y = paddleLocation.y + x;
}