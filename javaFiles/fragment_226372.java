public MyShapes() {
    //...       
    cardLayout = new CardLayout();
    frame.setLayout(cardLayout);

    frame.add(panel, "game");
    frame.add(panellevel, "level");
    frame.add(gameover, "over");
    frame.add(panelstart, "start");
    frame.add(statusbar, BorderLayout.SOUTH);

    cardLayout.show(frame.getContentPane(), "start");
    //...
}