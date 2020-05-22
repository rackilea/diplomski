internalFrame.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);

        internalFrame.addInternalFrameListener(new InternalFrameListener() {

            @Override
            public void internalFrameOpened(final InternalFrameEvent e) {

            }

            @Override
            public void internalFrameClosing(final InternalFrameEvent e) {

                // Do your confirmation stuff !!
                // Dispose the internal frame if needed !!

            }

            @Override
            public void internalFrameClosed(final InternalFrameEvent e) {

            }

            @Override
            public void internalFrameIconified(final InternalFrameEvent e) {

            }

            @Override
            public void internalFrameDeiconified(final InternalFrameEvent e) {

            }

            @Override
            public void internalFrameActivated(final InternalFrameEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void internalFrameDeactivated(final InternalFrameEvent e) {
                // TODO Auto-generated method stub

            }
        });