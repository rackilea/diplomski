class VideoFeed extends Thread {
        public void run() {
            webcam.open();
            boolean bool = true;
            while (bool) {
                try {
                    BufferedImage image = webcam.getImage();
                    var = BackEnd.refund(image,type[0]);
                    lblCamera.setIcon(new ImageIcon(image));
                    if (var[0] != null) {
                        bool = false;
                        webcam.close();
                        btnScan.doClick();
                    } else {
                        Thread.sleep(10);
                    }
                } catch (InterruptedException ex) {
                    System.out.println("Error: " + ex);
                }
            }
        }
    }