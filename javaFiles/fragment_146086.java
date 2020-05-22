WindowAdapter temp = new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
};

f.addWindowListener(temp);