public class TestMain {
    public static void main(String[] args) throws Exception {
        MyJFrame myFrameHello = new MyJFrame("Hello", 100, 100);
        MyJFrame myFrameGoodBye = new MyJFrame("Good Bye", 100, 250);
        myFrameHello.setVisible(true);
        myFrameGoodBye.setVisible(true);
    }
    private static class MyJFrame extends JFrame {
        public MyJFrame(String labelStr, int x, int y) {
            this.labelStr = labelStr;
            setDefaultCloseOperation(MyJFrame.EXIT_ON_CLOSE);
            label = new JLabel(" ");
            getContentPane().add(label, BorderLayout.NORTH);
            JButton button = new JButton("Click Me");
            button.addActionListener(new MyListener());
            getContentPane().add(button);
            setBounds(x, y, 0, 0);
            pack();
        }
        private JLabel label;
        private String labelStr;
        private class MyListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                label.setText(labelStr);
            }
        }
    }
}