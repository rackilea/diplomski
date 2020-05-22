//Create the list of images and put it in a scroll pane.
    list = new JGridPanel(1, imageNames.length);
    JScrollPane pictureScrollPane = new JScrollPane(picture);

    for (int i=0; i < imageNames.length; i++) {
        picture = new JButton();
        picture.setBackground(Color.black);
        ImageIcon img = createImageIcon("images/" + "#FileName" + ".gif");
        picture.setIcon(img);
        list.setComponent(picture, 0, i);

    }

    //Create a split pane with the two scroll panes in it.
    splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
            list, pictureScrollPane);
    splitPane.setOneTouchExpandable(true);
    splitPane.setDividerLocation(150);

    //Provide minimum sizes for the two components in the split pane.
    Dimension minimumSize = new Dimension(100, 50);
    list.setMinimumSize(minimumSize);
    pictureScrollPane.setMinimumSize(minimumSize);

    //Provide a preferred size for the split pane.
    splitPane.setPreferredSize(new Dimension(400, 200));