int ovalSize = 0;
            if (width < height) {
                ovalSize = width;
            } else {
                ovalSize = height;
            }

            int center = (width - ovalSize) / 2;

            for (int i = 0; i < 4; i++) {
                g.drawLine(i * width, 0, i * width, getHeight());
                g.drawOval(i * width + center, height * 10, ovalSize, ovalSize);
            }

            for (int i = 0; i < 11; i++) {
                g.drawLine(0, i * height, getWidth(), i * height);
            }