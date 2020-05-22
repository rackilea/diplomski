Thread paintThread = new Thread(new Runnable(){
    public void run() {
        while(true){
            Mat frame = new Mat();
            eyeCamera.read(frame);
            cameraPanel.setimage(matToBufferedImage(frame));
            cameraPanel.setSize(new Dimension(frame.width(),frame.height()));
            contentPane.repaint();
            cameraPanel.repaint();
            this.repaint();
        }
    }
}

paintThread.start();