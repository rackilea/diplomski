public class Test {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JLabel label = new JLabel("click me");
        label.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent me) {
            if (SwingUtilities.isRightMouseButton(me)) {
                System.out.println("right click");
            } else {
                System.out.println("left click");
            }
        });

        frame.getContentPane().add(label);
        frame.pack();
        frame.setVisible(true);
    }
}