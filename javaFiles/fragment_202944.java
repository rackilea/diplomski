public class Demo{
    private static BufferedImage bi;

    public static void main(String[] args){
        try{
            loadImage();

            SwingUtilities.invokeLater(new Runnable(){
                @Override
                public void run(){
                    createAndShowGUI();
                }
            });
        }
        catch (IOException e){
            // handle exception
        }
    }

    private static void loadImage() throws IOException{
        bi = ImageIO.read(new File("src/resource/braveheart.PNG"));
    }

    private static void createAndShowGUI(){
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                Graphics g2 = g.create();
                g2.drawImage(bi, 0, 0, getWidth(), getHeight(), null);
                g2.dispose();
            }

            @Override
            public Dimension getPreferredSize(){
                return new Dimension(bi.getWidth(), bi.getHeight());
            }
        };

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}