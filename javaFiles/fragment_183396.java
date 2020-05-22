public Test2() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setMinimumSize(new Dimension(800, 600));
    paintPanel = new  PaintPanel();
    getContentPane().add(paintPanel, BorderLayout.CENTER);
    pack();

    paintPanel.initGame();  
}