public void drawCornerRectangle(Graphics2D g, int x, int y, int width, int height, int cornerLength) {
        //check width, height and cornerLength
        if ((width < 0) || (height < 0) || (cornerLength < 1)) {
            return;
        }
        //check if width or height is 0
        if(width == 0) {
            g.drawLine(x, y, x, y + cornerLength);
            g.drawLine(x, y + height, x, (y + height) - cornerLength);
            return;
        } else if (height == 0) {
            g.drawLine(x, y, x + cornerLength, y);
            g.drawLine(x + width, y, (x + width) - cornerLength, y);
            return;
        }
        //check cornerLength
        if(cornerLength > width/2 && cornerLength > height/2) {
            g.drawRect(x, y, width, height);
        } else {
            //left up corner
            g.drawLine(x, y, x + cornerLength, y);
            g.drawLine(x, y, x, y + cornerLength);

            //right up corner
            g.drawLine(x + width, y, (x + width) - cornerLength, y);
            g.drawLine(x + width, y, x + width, y + cornerLength);

            //left down corner
            g.drawLine(x, y + height, x + cornerLength, y + height);
            g.drawLine(x, y + height, x, (y + height) - cornerLength);

            //right down corner
            g.drawLine(x + width, y + height, (x + width) - cornerLength, y + height);
            g.drawLine(x + width, y + height, x + width, (y + height) - cornerLength);
        }
    }