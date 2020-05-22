public BoardUI(LayoutManager layout, Game game, String word) {
    super(layout);
    this.b = new Board();
    this.game = game;
    initComponents(word);
}