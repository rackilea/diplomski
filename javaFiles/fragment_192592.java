// renderer
    final XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();

    // Reading the image
    try {
        myPicture = ImageIO.read(new File("\\\\Users2\\blabla\\Data\\MyPictures\\x.png"));
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Setting up a timer
    timer2 = new java.util.Timer();

    Object source = event.getSource();
    if (source == someButton) {

                task2 = new java.util.TimerTask() {
                    @Override
                    public void run() {
                        if (check == true) {
                            if (microContConnected()) {

                                 x1 = microCont.getX();
                                 y1 = microCont.getY();

                                renderer.removeAnnotations();

                                XYImageAnnotation img2 = new XYImageAnnotation(
                                        x1, y1, myPicture);
                                renderer.addAnnotation(img2,
                                        Layer.FOREGROUND);
                            }
                        }
                    }
                };
                timer2.scheduleAtFixedRate(task2, 50, 50);
            }