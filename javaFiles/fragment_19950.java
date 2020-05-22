// getting screen coordinates of a node (or whole scene)
            Bounds b = node.getBoundsInParent(); 
            int x = (int)Math.round(primaryStage.getX() + scene.getX() + b.getMinX());
            int y = (int)Math.round(primaryStage.getY() + scene.getY() + b.getMinY());
            int w = (int)Math.round(b.getWidth());
            int h = (int)Math.round(b.getHeight());
            // using ATW robot to get image
            java.awt.Robot robot = new java.awt.Robot();
            java.awt.image.BufferedImage bi = robot.createScreenCapture(new java.awt.Rectangle(x, y, w, h));
            // convert BufferedImage to javafx.scene.image.Image
            java.io.ByteArrayOutputStream stream = new java.io.ByteArrayOutputStream();
            // or you can write directly to file instead
            ImageIO.write(bi, "png", stream);
            Image image = new Image(new java.io.ByteArrayInputStream(stream.toByteArray()), w, h, true, true);