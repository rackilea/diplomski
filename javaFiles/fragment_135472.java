public void reset(){
 GameBoard.this.setVisible(false);

String tempName = GameBoard.this.nameLabel.getText();

 GameBoard.this.dispose();

 GameBoard gb= new GameBoard("Constructor Without Taking Name");
 gb.nameLabel.setText(tempName);

 score = 0;
}