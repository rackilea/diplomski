class GUI extends JFrame {

    public static void main(String[] args) {

        new GUI();
    }

    GUI() {

        Border[] borders = new Border[]{
                   BorderFactory.createLineBorder(Color.GREEN, 3, true),
                   BorderFactory.createLineBorder(Color.BLACK, 3, true),
                   BorderFactory.createLineBorder(Color.GRAY, 6, true)};
        Border border = BorderFactory.createCompoundBorder(borders[2], 
                        BorderFactory.createCompoundBorder(borders[1], borders[0]));
        JButton button = new JButton("Button");
        button.setBorder(border);

        add(button);
        pack();
        setVisible(true);
    }
}