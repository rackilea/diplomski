double ratio = (double) labelPic.getWidth() / (double) labelPic.getHeight();
        // Do image scale, scaledW is the new Width, and LabelPic.getHeight is the new Height.
        int scaledW = (int) (image.getHeight() * ratio);
        image = new BufferedImage(scaledW, labelPic.getHeight(), BufferedImage.SCALE_FAST);// Edit here
        ImageIcon icon = new ImageIcon(image);

        labelPic.setVisible(true);
        labelPic.setIcon(icon);
        labelPic.revalidate();
        labelPic.repaint();