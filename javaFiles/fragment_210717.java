...
class power extends JFrame {
    JFileChooser chooser;
    BufferedImage img;
    JButton button,button2;
    JFrame comp;
    String filename;
    File file ; 
    JLabel label; // ADDED

    public power() {
    ...
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==button) {
                    chooser.showOpenDialog(null);
                    file = chooser.getSelectedFile();

                    try {
                        img=ImageIO.read(file);
                        ImageIcon icon=new ImageIcon(img); // ADDED
                        label.setIcon(icon); // ADDED

                        Dimension imageSize = new Dimension(icon.getIconWidth(),icon.getIconHeight()); // ADDED
                        label.setPreferredSize(imageSize); // ADDED

                        label.revalidate(); // ADDED
                        label.repaint(); // ADDED
                    }
                    catch(IOException e1) {}
                }

                if (e.getSource()==button2){
                    comp.setVisible(true);
                }
            }
        };

        //ImageIcon icon=new ImageIcon(img); // REMOVED
        //JLabel label=new JLabel(icon); // REMOVED
        label = new JLabel(); // ADDED

        JPanel secpanel=new JPanel();
        ...