final Image finalImage = image;
for(int i = 0; i < fileRefernces.size(); i++) { 
    final int finalCounter = i + 1;
    Thread t = new Thread(new Runnable() {
        public void run() {
            JLabel pageNumber = new JLabel("<html><font color='#003b86'>PAGE" + finalCounter + "</font></html>", JLabel.LEFT);
            JLabel imageLabel = new JLabel(finalImage, JLabel.LEFT);
            // commented code
        }
    });
}