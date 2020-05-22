public void draw() {
        background(0);
        map.draw();
        addKey();

        if (lastSelected != null)
        {
            lastSelected.showToolTip(this,lastSelected.getScreenPosition(map).x,lastSelected.getScreenPosition(map).y);

        }

    }