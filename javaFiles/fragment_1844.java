class RainbowRunner{
    public static void main(String[] args){     
        // Run the GUI code on the EDT
        SwingUtilities.invokeLater(new Runnable() {     
            @Override
            public void run() {
                JFrame frame = new JFrame("Rainbow Frame");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new DrawingSpace());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);             
            }
        }); 
    }
}