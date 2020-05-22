// Viewport (needs to be done on canvas resize only)
GL11.glViewport(0.0, 0.0,                   // Set viewport size
                canvas.getBounds().width,
                canvas.getBounds().height);

// Projection (only needs to be set once in most cases)
GL11.glMatrixMode(GL11.GL_PROJECTION);        // Select projection matrix
GL11.glLoadIdentity();                        // Clear it
GL11.glOrtho(0.0, 1.0, 0.0, 1.0, -1.0, 1.0);  // Set your projection

// model/view transforms
GL11.glMatrixMode(GL11.GL_MODELVIEW);  // Select modelview matrix
GL11.glLoadIdentity();                 // Clear it

// Draw (shortcut)
GL11.glRectf(0.1f, 0.1f, 0.9f, 0.9f);