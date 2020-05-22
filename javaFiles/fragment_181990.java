WindowAdapter adapter = new WindowAdapter() {
    @Override
    public void windowCloses(WindowEvent e) {
        doSomething();
    }
}