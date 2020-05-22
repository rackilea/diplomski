addUpperPane.add(itemBox,BorderLayout.EAST);
    addUpperPane.add(addItem,BorderLayout.WEST);
    addUpperPane.add(new JSeparator(JSeparator.HORIZONTAL));

    //put everything together

    add(addUpperPane,BorderLayout.NORTH);
    add(addLowerPane,BorderLayout.SOUTH);