Canvas canvas = new Canvas(400, 400);
GraphicsContext gc = canvas.getGraphicsContext2D();
gc.setFill(Color.WHITE);
gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
gc.setFill(Color.BLACK);
gc.fillText("Hello world", 30, 30);
gc.save();
gc.setGlobalBlendMode(BlendMode.DIFFERENCE);
gc.setFill(Color.WHITE);
gc.fillRect(10, 10, 100, 100);
gc.restore(); // restore old settings

// some more rendering with old settings
gc.fillRect(100, 100, 100, 100);