for(int i=0;i<10;i++) {
        for(int j=0;j<10;j++) {
            JPanel panel = new JPanel();
            addListener(panel, j, i);
            panel.setBorder(new LineBorder(Color.black,1));
            grid.add(panel);