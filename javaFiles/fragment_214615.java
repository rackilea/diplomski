public static void main(String[] args) {
    List<Integer> l = new ArrayList<Integer>(5);
    CountDownLatch jFrameDrawing = new CountDownLatch(1);
    JFrame gui = new JFrame();
    gui.add(new MyPanel(), jFrameDrawing); // add the counter
    try {
        jFrameDrawing.await();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    l.add(10);
}