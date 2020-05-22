void setup()
{
    setup(500, 500, P2D);
    frameRate(-1);                                      // set unlimited frame rate
    ((PJOGL)PGraphicsOpenGL.pgl).gl.setSwapInterval(1); // enable waiting for vsync
                                                        // before swapping back/front buffers
}