public static void main(String[] args) {
        JFrame frame = new JFrame();
        CirclePanel panel = new CirclePanel();
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }