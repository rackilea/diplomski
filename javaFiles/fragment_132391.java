public void actionPerformed(ActionEvent e) {
            System.out.println("Changing image...");
            if (testIcon.getImage() == image1) {
                testIcon.setImage(image2);
            } else {
                testIcon.setImage(image1);
            }
            jTabbedPane.repaint();//calling repaint after icon change
        }