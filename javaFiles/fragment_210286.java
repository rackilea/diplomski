final int index = i;
SwingUtilities.invokeAndWait(new Runnable() {
    public void run() {
        new VisualSerializer(P[index], Q[index], folder + "C" + index).run();
    }
});