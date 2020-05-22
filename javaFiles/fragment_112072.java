if(frame == null)
                frame = new JFrame();
            else {
                //remove the previous JFrame
                frame.setVisible(false);
                frame.dispose();
                //create a new one
                frame = new JFrame();
            }