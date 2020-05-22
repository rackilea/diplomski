private class MyLabel extends JLabel {
    public MyLabel(String text) {
        super(text);
    }
    public boolean equals(Object obj) {
        return true;
    }
};


public MyPanel() {
    getContentPane().setLayout(new GridLayout());
    getContentPane().add(new MyLabel("Label 1"));
    getContentPane().add(new MyLabel("Label 2"));
    getContentPane().add(new MyLabel("Label 3"));
}