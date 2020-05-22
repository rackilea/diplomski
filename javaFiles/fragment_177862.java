public class Test implements ActionListener {
    ImageIcon imgIcon;
    JFrame jf;
    JPanel jp_image, jp_option;
    BufferedImage img;
    private JLabel imageLabel = new JLabel();

    Test() {
        // ...

        jp_image.add(imageLabel); //!!

        // ...
    }

    public void actionPerformed(ActionEvent ae) {
        String arg = ae.getActionCommand();
        if (arg.equals("New...")) {
            // ...

            try {
                img = ImageIO.read(file);
                imageLabel.setIcon(new ImageIcon(img)); //!!
            } catch (Exception e) {
                e.printStackTrace();
            }
        }