frame.addWindowListener(new WindowListener() {
                public void windowClosing(WindowEvent e) {
                    //Allows for multiple instances and properly closing
                    //only one of the Frames instead of all of them
                    frame.dispose();
                }
                public void windowOpened(WindowEvent e) {}              
                public void windowClosed(WindowEvent e) {}
                public void windowIconified(WindowEvent e) {}
                public void windowDeiconified(WindowEvent e) {}
                public void windowActivated(WindowEvent e) {}
                public void windowDeactivated(WindowEvent e) {}
            });