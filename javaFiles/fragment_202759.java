class SnakeEngine extends SurfaceView implements Runnable {
    public void update() {
     if (score == 5){
        Intent intent = new Intent(this, level2.class);
        getContext().startActivity(intent);
    }
}