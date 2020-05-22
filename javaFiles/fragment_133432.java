//Draw rectangle at mouse coordinates
        gt.setColor(Color.MAGENTA);
        Point m = MouseInfo.getPointerInfo().getLocation();
        try {
            gt.getTransform().createInverse().transform(m, m);
            gt.fillRect((int) m.getX() - 8, (int) m.getY() - 8, 16, 16);
        } catch (java.awt.geom.NoninvertibleTransformException e) {
            System.err.println(e);
        }