panel.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            clickLocation.setSize(e.getX(), e.getY());
        }
    });
    Action cutAction = new TestAction("Cut", clickLocation);
    Action copyAction = new TestAction("Copy", clickLocation);
    Action pasteAction = new TestAction("Paste", clickLocation);