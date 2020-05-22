Runnable moveTask = new Runnable () {
    public void run() {
        while (true) {
            Thread.sleep(...);
            SwingUtilities.invokeLater(theActualMoveHere());
        }
    }
}
new Thread(moveTask).start();