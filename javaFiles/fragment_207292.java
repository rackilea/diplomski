tChart1.addMouseMotionListener(new MouseMotionAdapter() {

        @Override
        public void mouseMoved(MouseEvent e) {
             while (updatingData) ;
        }
    });