Box box = Box.createVerticalBox();
    JLabel label1 = new JLabel("test1, the beginning");
    label1.setAlignmentX(Component.RIGHT_ALIGNMENT);
    box.add(label1);

    JLabel label2 = new JLabel("test2, some more");
    label2.setAlignmentX(Component.RIGHT_ALIGNMENT);
    box.add(label2);

    JLabel label3 = new JLabel("test3");
    label3.setAlignmentX(Component.RIGHT_ALIGNMENT);
    box.add(label3);


    add(box);