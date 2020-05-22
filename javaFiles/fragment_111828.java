public void erase(JFrame frame, BufferedImage world, BufferedImage orig_world, int x, int y) throws IOException {
    for (int stepper_y = 0; stepper_y < this.image.getHeight(); stepper_y++) {
        for (int stepper_x = 0; stepper_x < this.image.getWidth(); stepper_x++) {
            int sprite_pixel = orig_world.getRGB(x + stepper_x, y + stepper_y);
            // get pixel from orginal sprite
            int sprite_alpha = (sprite_pixel >> 24) & 0xff;
            // get alpha value from original sprite
            int sprite_red = (sprite_pixel >> 16) & 0xff;
            // get red value from original sprite
            int sprite_green = (sprite_pixel >> 8) & 0xff;
            // get green value from original sprite
            int sprite_blue = sprite_pixel & 0xff;
            // get blue value from original sprite

            int pixel = (sprite_alpha << 24) | (sprite_red << 16) | (sprite_green << 8) | sprite_blue;
            // set the pixel equal to the old values
            world.setRGB(x + stepper_x, y + stepper_y, pixel);
            // place the pixel
        }
    }
}