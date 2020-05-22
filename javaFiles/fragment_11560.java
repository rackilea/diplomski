protected void updateHoneyComb() {
        GeneralPath path = new GeneralPath();

        double rowHeight = ((getHeight() * 1.14f) / 3f);
        double colWidth = getWidth() / 3f;

        double size = Math.min(rowHeight, colWidth) / 2d;

        double centerX = size / 2d;
        double centerY = size / 2d;

        double width = Math.sqrt(3d) * size;
        double height = size * 2;
        for (float i = 0; i < 6; i++) {
            float angleDegrees = (60f * i) - 30f;
            float angleRad = ((float) Math.PI / 180.0f) * angleDegrees;

            double x = centerX + (size * Math.cos(angleRad));
            double y = centerY + (size * Math.sin(angleRad));

            if (i == 0) {
                path.moveTo(x, y);
            } else {
                path.lineTo(x, y);
            }
        }
        path.closePath();

        cells.clear();
        double yPos = size / 2d;
        for (int row = 0; row < 3; row++) {
            double offset = (width / 2d);
            int colCount = 2;
            if (row % 2 == 0) {
                offset = 0;
                colCount = 3;
            }
            double xPos = offset;
            for (int col = 0; col < colCount; col++) {
                AffineTransform at = AffineTransform.getTranslateInstance(xPos + (size * 0.38), yPos);
                Area area = new Area(path);
                area = area.createTransformedArea(at);
                cells.add(area);
                xPos += width;
            }
            yPos += height * 0.75;
        }

    }