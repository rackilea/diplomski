public static void main(String[] args) {
    List<Integer> l = new ArrayList<Integer>(5);
    CountDownLatch jFrameDrawing = new CountDownLatch(3); // NOTE 3
    JFrame gui = new JFrame();
    gui.add(new MyPanel(), jFrameDrawing); // draw once
    gui.setSize(100,50); // draw again
    gui.setVisible(true); // draw a third time
    try {
        jFrameDrawing.await();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    l.add(10);
}