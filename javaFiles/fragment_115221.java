Rectangle cameraView = new Rectangle(playerX - getWidth() / 2, playerY - getHeight() / 2, getWidth(), getHeight());
    for (int x = 0; x < map.length; x++) {
        for (int y = 0; y < map[0].length; y++) {
            if (!cameraView.contains(x*blockSize, y*blockSize))
                continue;
            switch (map[x][y]) {
            case "0":
                break;
            case "1":
                if (block != null) {
                    TexturePaint tp0 = new TexturePaint(block, new Rectangle(0, 0, blockSize, blockSize));
                    g2.setPaint(tp0);
                }
                g.fillRect(y * blockSize, x * blockSize, 20, 20);
                break;
            }
        }
    }