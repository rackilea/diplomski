public void actionPerformed(ActionEvent e) {
            label = new Label();//Added
            try {
                label.setIcon(new ImageIcon
                 (new URL("file:/C:/Users/Ashad/JunoWorkspace/FYP1/table.png")));
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            }