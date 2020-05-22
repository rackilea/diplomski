/*
             * to print one image we need to have:
             * - one BufferedImage.
             * - one bitonal algorithm to define what and how print on image.
             * - one image wrapper to determine the command set to be used on 
             * image printing and how to customize it.
             */

            // creating the EscPosImage, need buffered image and algorithm.
            URL imageURL = getURL("dog.png"); 
            BufferedImage  imageBufferedImage = ImageIO.read(imageURL);


            // this wrapper uses esc/pos sequence: "GS 'v' '0'"
            RasterBitImageWrapper imageWrapper = new RasterBitImageWrapper();



            escpos = new EscPos(new PrinterOutputStream(printService));


            escpos.feed(5);
            escpos.writeLF("BitonalThreshold()");
            // using bitonal threshold for dithering
            Bitonal algorithm = new BitonalThreshold(); 
            EscPosImage escposImage = new EscPosImage(imageBufferedImage, algorithm);     
            escpos.write(imageWrapper, escposImage);

            escpos.feed(5);

            escpos.cut(EscPos.CutMode.PART);