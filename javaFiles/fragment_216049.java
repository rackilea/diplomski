int mb = mandelbrot(c, z0, 0, maxRecurse);

if (mb == -1) {
    image.setRGB(x, y, 0);
} else {
    // set the color of your image as usual
}