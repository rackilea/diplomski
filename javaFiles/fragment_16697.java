float imageXScale = ctmNew.getXScale();
            float imageYScale = ctmNew.getYScale();
            System.out.println("position = " + ctmNew.getXPosition() + ", " + ctmNew.getYPosition());
            // size in pixel
            System.out.println("size = " + imageWidth + "px, " + imageHeight + "px");
            // size in page units
            System.out.println("size = " + imageXScale + "pu, " + imageYScale + "pu");
            // size in inches 
            imageXScale /= 72;
            imageYScale /= 72;
            System.out.println("size = " + imageXScale + "in, " + imageYScale + "in");
            // size in millimeter
            imageXScale *= 25.4;
            imageYScale *= 25.4;
            System.out.println("size = " + imageXScale + "mm, " + imageYScale + "mm");

            System.out.printf("dpi  = %.0f dpi (X), %.0f dpi (Y) %n", image.getWidth() * 72 / ctmNew.getXScale(), image.getHeight() * 72 / ctmNew.getYScale());