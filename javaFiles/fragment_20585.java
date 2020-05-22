public final class JDialogDemo {
    private static BufferedImage bi;

    public static void main(String[] args){
        try {
            loadImage();

            SwingUtilities.invokeLater(new Runnable(){
                @Override
                public void run() {
                    createAndShowGUI();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadImage() throws IOException{
        bi = ImageIO.read(JDialogDemo.class.getResource("../resource/close-icon.png"));
    }

    private static void createAndShowGUI(){
        final JDialog dialog = new JDialog();
        dialog.setUndecorated(true);

        final JPanel panel = new JPanel(){
            @Override
            public Dimension getPreferredSize(){
                return new Dimension(400, 40);
            }
        };
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.setBackground(new Color(238, 221, 130));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        final JLabel closeLabel = new JLabel();
        closeLabel.setIcon(new ImageIcon(bi));
        closeLabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                dialog.dispose();
            }
        });

        panel.add(new JLabel("There are deleted items that used to be in this folder."));
        panel.add(Box.createHorizontalGlue());
        panel.add(closeLabel);
        dialog.add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}