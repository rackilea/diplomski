@Override
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        Graphics2D g2D = (Graphics2D) g;
        int xp[];
        int yp[];
        Polygon shape = null;
        Rectangle shapeRect = null;
        //Todo remove the shape and used the shapeRect
        if(tabPlacement == TOP){
            xp = new int[]{x, x, x, x + w, x + w, x + w, x + w, x};
            yp = new int[]{(y + positionYLine + heightLine), y + positionYLine, y + positionYLine, y + positionYLine, y + positionYLine, y + positionYLine, y + positionYLine + heightLine, y + positionYLine + heightLine};
            shape = new Polygon(xp, yp, xp.length);
        }else if(tabPlacement == BOTTOM){
            y += 20;
            xp = new int[]{x, x, x, x + w, x + w, x + w, x + w, x};
            yp = new int[]{(y + heightLine), y, y, y, y, y, y + heightLine, y + heightLine};
            shape = new Polygon(xp, yp, xp.length);
        }else if(tabPlacement == LEFT){
            //xp = new int[]{0, 0, 0, h, h, h, h, 0};
            //yp = new int[]{(y + heightLine), y, y, y, y, y, y + heightLine, y + heightLine};
            shapeRect = new Rectangle(x + heightLine - 2, y + (heightLine), heightLine, w / (tabPane.getTabCount()));
        }else{
            //super.paintTabBackground(g, tabPlacement, tabIndex, x, y, w, h, isSelected);
            shapeRect = new Rectangle(x + w - heightLine, y + (heightLine), heightLine, w / (tabPane.getTabCount()));
        }

        if (isSelected) {
            g2D.setColor(selectedAreaContentBackground);
            g2D.setPaint(selectedAreaContentBackground);
            tabPane.setForegroundAt(tabIndex, selectedForeground);

        } else {
            if (tabPane.isEnabled() && tabPane.isEnabledAt(tabIndex)) {
                g2D.setColor(areaContentBackground);
                g2D.setPaint(areaContentBackground);
            } else {
                g2D.setColor(disableAreaContentBackground);
                g2D.setPaint(disableAreaContentBackground);
            }
            tabPane.setForegroundAt(tabIndex, foreground);
        }
        if(shape != null){
            g2D.fill(shape);
        }else if (shapeRect != null){
            g2D.fill(shapeRect);
        }
    }