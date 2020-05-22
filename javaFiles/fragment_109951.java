Robot r = new Robot();
                r.mouseMove(635, 210); // brings focus on login popup window, got location(x,y coordinates) from Mouse-Position chrome plugin
                // left-click mouse on the location
                r.mousePress(MouseEvent.BUTTON1_MASK);
                r.mouseRelease(MouseEvent.BUTTON1_MASK);
                //simulating Enter key press, this automatically clicks login and submits the form
                r.keyPress(KeyEvent.VK_ENTER);
                r.keyRelease(KeyEvent.VK_ENTER);