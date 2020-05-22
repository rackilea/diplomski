// original cardPanel1 name is "card1"

    CardLayout lay = (CardLayout)parentPanel.getLayout();
    lay.removeLayoutComponent(cardPanel1);
    lay.addLayoutComponent(cardPanel1, "card4");

    // cardPanel1 can now be shown using "card4" name