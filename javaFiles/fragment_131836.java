public void componentMoved(ComponentEvent e) {

                Rectangle r = new Rectangle();

                MyInternalFrame mif = MyInternalFrame.this;
                JDesktopPane dp = mif.getDesktopPane();

                if (mif.getX() + mif.getWidth()> dp.getWidth()) {
                    mif.setLocation(mif.getDesktopPane().getWidth()-mif.getWidth(),mif.getY());
                }

                if (mif.getY() + mif.getHeight()> dp.getHeight()) {
                    mif.setLocation(mif.getX(), mif.getDesktopPane().getHeight()-mif.getHeight());
                }

                if (mif.getX()<0) {
                    mif.setLocation(0, mif.getY());
                }

                if (mif.getY()<0) {
                    mif.setLocation(mif.getX(), 0);
                }

            }

        });