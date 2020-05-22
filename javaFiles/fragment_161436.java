public static void main(String args[])  {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            JFrame frame = new JFrame("Test Image");

            frame.setLayout(new BorderLayout());
            try {
                frame.add(new JLabel(new ImageIcon(new URL(YOUR_IMAGE_URL))),
                        BorderLayout.NORTH);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            frame.add(new JButton("Button"), BorderLayout.CENTER);

            frame.pack();
            frame.setVisible(true);
        }
    });
}