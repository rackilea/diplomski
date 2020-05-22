final MouseListener testList = new MouseListener() {

              @Override
              public void mouseReleased(MouseEvent e) {
                dt.revalidate();
              }

              @Override
              public void mousePressed(MouseEvent e) {
              }

              @Override
              public void mouseExited(MouseEvent e) {
              }

              @Override
              public void mouseEntered(MouseEvent e) {
              }

              @Override
              public void mouseClicked(MouseEvent e) {
              }
            };
            // causes maximized internal frames to be resized..
            dt.addComponentListener(componentListener);

            for (JInternalFrame jif : dt.getAllFrames()) {
              for (Component comp : jif.getComponents()) {
                if (comp instanceof BasicInternalFrameTitlePane) {
                  comp.addMouseListener(testList);
                }
              }
            }        

            final JCheckBox outLineDragMode = new JCheckBox("Outline Drag Mode");
            ActionListener dragModeListener = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                  if (outLineDragMode.isSelected()) {
                    dt.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
                    for (JInternalFrame jif : dt.getAllFrames()) {
                      for (Component comp : jif.getComponents()) {
                        if (comp instanceof BasicInternalFrameTitlePane) {
                          comp.removeMouseListener(testList);
                        }
                      }
                    }
                  } else {
                    dt.setDragMode(JDesktopPane.LIVE_DRAG_MODE);
                    for (JInternalFrame jif : dt.getAllFrames()) {
                      for (Component comp : jif.getComponents()) {
                        if (comp instanceof BasicInternalFrameTitlePane) {
                          comp.addMouseListener(testList);
                        }
                      }
                    }
                  }
                }
            };