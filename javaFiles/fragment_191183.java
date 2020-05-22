@Override
touchDown(InputEvent event, float x, float y, int pointer, int button) {
    Vector3 input = new Vector3(x, y, 0);
    cam.unproject(input);

    if (ball.getBoundingCircle().contains(input.x, input.y)) {
        ballBounce();
    }
}