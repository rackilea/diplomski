class MyCanvas extends Canvas {

    Image image;
    boolean imageFetchFailed;

    protected void paint(Graphics g) {
        if (image == null) {
            fetchImage();
            g.drawString("Fetching...", getWidth() >> 1, getHeight() >> 1, Graphics.HCENTER | Graphics.TOP)

        } else if (imageFetchFailed) {
            g.drawString("Failed to fetch image", getWidth() >> 1, getHeight() >> 1, Graphics.HCENTER | Graphics.TOP)
        } else {
            g.drawImage(image, 0, 0, 0);
        }
    }


    private void fetchImage() {
        new Thread(new Runnable() {
            public void run() {
                HttpConnection httpConnection = null;
                try {
                    httpConnection = (HttpConnection) Connector
                            .open("http://10.4.71.200/stage/images/front/car.png");
                    image = Image.createImage(httpConnection.openInputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                    imageFetchFailed = true;
                }

                if (httpConnection != null) {
                    try {
                        httpConnection.close();
                    } catch (IOException ignored) {
                    }
                }

                // Following will trigger a paint call 
                // and this time image wont be null and will get painted on screen
                repaint();    
            }
        }).start();
    }
}