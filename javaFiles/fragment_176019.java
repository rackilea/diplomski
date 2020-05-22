int[] colors = new int[img.getWidth() * img.getHeight()];
    img.getPixels(colors, 0, img.getWidth(), 0, 0, img.getWidth(), img.getHeight());
    for (int i = 0; i < colors.length; i++) {
            int y = (int) (i / img.getWidth());
            int x = i % img.getWidth();
            int R = android.graphics.Color.red(colors[i]);
            int G = android.graphics.Color.green(colors[i]);
            int B = android.graphics.Color.blue(colors[i]);
        }
    }