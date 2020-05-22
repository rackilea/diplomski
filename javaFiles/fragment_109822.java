canvas.addPaintListener(new PaintListener() {
              public void paintControl(PaintEvent event) {
                 //Obtain the next frame
                ImageData imageData = imageDataArray[iad.imageNumber];
                Image imageFrame = new Image(display, imageData);

                // Create the image to fill the canvas
                Image image = new Image(display, canvas.getBounds());

                // Set up the offscreen gc
                GC gcImage = new GC(image);

                //Draw the image offscreen
                gcImage.setBackground(event.gc.getBackground());
                gcImage.drawImage(imageFrame, 0, 0);

                // Draw the offscreen buffer to the screen
                event.gc.drawImage(image, 0, 0);

                imageFrame.dispose();
                image.dispose();
                gcImage.dispose();
              }
            });