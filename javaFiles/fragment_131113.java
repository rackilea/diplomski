private void checkCollision() {

    if (ball.getRect().getMaxY() > Commons.BOTTOM_EDGE) {
        stopGame();
    }

    int j = 0;
    for (int i = 0; i < N_OF_BRICKS; i++) {

        if (bricks[i].isDestroyed()) {
            j++;
        }
    }
    if (j == N_OF_BRICKS) {
        message = "Pay Day";
        stopGame();
    }
}