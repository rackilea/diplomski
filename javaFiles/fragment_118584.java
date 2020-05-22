double currentX = stage.getX();
    double currentY = stage.getY();
    double currentWidth = stage.getWidth();
    double currentHeight = stage.getHeight();
    new Thread(()->{
        long initial = System.currentTimeMillis();
        while(true) {
            long current = System.currentTimeMillis();
            long delta = current - initial;
            if(delta > MILLIS) {
                break;
            }
            double prc = 1 - delta/(double)MILLIS;
            Platform.runLater(()->{
                stage.setX(currentX*prc);
                stage.setY(currentY*prc+(1-prc)*(Screen.getPrimary().getBounds().getMaxY() - 25));
                stage.setWidth(currentWidth*prc);
                stage.setHeight(currentHeight*prc);
                stage.setOpacity(prc);
            });

            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            Platform.runLater(()-> stage.close());
    }).start();