table.add(inputField).colspan(2).center().width(width - OFFSET).expand().padRight(2);
    table.row();
    table.add(okButton).width(width / 2 - OFFSET / 2).right();
    table.add(closeButton).width(width / 2 - OFFSET / 2).left();
    table.pad(5);
    table.debug();