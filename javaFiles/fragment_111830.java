// to spawn a sprite on top of another image.
public void spawn(JFrame frame, BufferedImage world) throws IOException, InterruptedException {
    for (int sprite_y = 0; sprite_y < this.image.getHeight(); sprite_y++) {
        for (int sprite_x = 0; sprite_x < this.image.getWidth(); sprite_x++) {
            int sprite_pixel = this.image.getRGB(sprite_x, sprite_y);
            int sprite_alpha = (sprite_pixel >> 24) & 0xff;
            int sprite_red = (sprite_pixel >> 16) & 0xff;
            int sprite_green = (sprite_pixel >> 8) & 0xff;
            int sprite_blue = sprite_pixel & 0xff;
            int pixel = (sprite_alpha << 24) | (sprite_red << 16) | (sprite_green << 8) | sprite_blue;
            world.setRGB(x + sprite_x, y + sprite_y, pixel);
        }
    }
}

public void erase(JFrame frame, BufferedImage world, BufferedImage orig_world) throws IOException {
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