public MouseAdapter getMouseAdapter() {
        return new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                app.setLastClickedComponent(ADVTableOperations.this);
                rowClicked = rowAtPoint(e.getPoint());
                colClicked = columnAtPoint(e.getPoint());
                if (e.isPopupTrigger() && isPopUpEnabled()) {
                    popUpMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                app.setLastClickedComponent(ADVTableOperations.this);
                rowClicked = rowAtPoint(e.getPoint());
                colClicked = columnAtPoint(e.getPoint());

                if (e.isPopupTrigger() && isPopUpEnabled()) {
                    popUpMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        };
    }