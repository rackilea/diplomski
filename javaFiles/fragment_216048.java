public static int mandelbrot(ComplexNumber c, ComplexNumber z, int i, int n) {
    if (i >= n) {
        // mandelbrot function does not diverge after n iterations.
        // Returning -1 as a magic value to indicate that the point c is in the mandelbrot set.
        // Values may already be outside of the mandelbrot set in the 0th iteration, so returning -1 makes more sense.
        return -1;
    } else if (z.abs() >= 2.0) {
        // mandelbrot function is diverging after i iterations.
        return i;
    } else {
        // recursively call mandelbrot function with an updated z and an incremented i.
        return mandelbrot(c, z.squared().add(c), i + 1, n);
    }
}