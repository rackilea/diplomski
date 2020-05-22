// Draw horizontal lines
        float curY = getOccupiedAreaBBox().getTop();
        for (int i = 0; i <= heights.size(); i++) {
            canvas.moveTo(getOccupiedAreaBBox().getLeft() - 3, curY);
            canvas.lineTo(getOccupiedAreaBBox().getRight() + 3, curY + r.nextInt(4));
            if (i < heights.size()) {
                float curHeight = heights.get(i);
                curY -= curHeight;
            }
        }