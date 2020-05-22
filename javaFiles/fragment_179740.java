public static void main (String [] args)
{
    final JFrame frame = new JFrame ();

    JButton button = new JButton (new AbstractAction ("Make Screenshot!")
    {
        @Override
        public void actionPerformed (ActionEvent e)
        {
            Dimension size = frame.getSize ();
            BufferedImage img = new BufferedImage (size.width, size.height, BufferedImage.TYPE_3BYTE_BGR);
            Graphics g = img.getGraphics ();
            frame.paint (g);
            g.dispose ();
            try
            {
                ImageIO.write (img, "png", new File ("screenshot.png"));
            }
            catch (IOException ex)
            {
                ex.printStackTrace ();
            }
        }
    });

    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.getContentPane ().setLayout (new BorderLayout ());
    frame.getContentPane ().add (button, BorderLayout.CENTER);
    frame.pack ();
    frame.setVisible (true);
}