@Override
public void start(Stage primaryStage) {
    GridPane chessBoardPane = chessBoard.createBoard();

    Player player1 = new Player();
    Player player2 = new Player();
    this.startGame(player1, player2);

    primaryStage.setScene(new Scene(chessBoardPane, 400, 400));
    primaryStage.show();
}