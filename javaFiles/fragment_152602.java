public void gameEngine(BufferStrategy strategy) {

    // Main loop
    while (!done) {
        // Prepare for rendering the next frame
        // ...

        // Render single frame
        do {
            // The following loop ensures that the contents of the drawing buffer
            // are consistent in case the underlying surface was recreated
            do {
                // Get a new graphics context every time through the loop
                // to make sure the strategy is validated
                Graphics2D g2D = (Graphics2D) strategy.getDrawGraphics();

                // Render to graphics
                g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER)); //sprites overlap instead of overwrite
                if (game == null) {
                    drawSplash(g2D);
                } else {
                    drawBoard(g2D);
                }
                // Dispose the graphics
                g2D.dispose();

                // Repeat the rendering if the drawing buffer contents
                // were restored
            } while (strategy.contentsRestored());

            // Display the buffer
            strategy.show();

            // Repeat the rendering if the drawing buffer was lost
        } while (strategy.contentsLost());
    }
}