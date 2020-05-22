{
  Tile tiles [][] = new Tile[10][10];
  for(int i=0; i<10; i ++){
    for(int j =0; j<10; j++){
      tiles[i][j].position = i*10+j;
      tiles[i][j].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent e) {
                    System.out.println(((Tile)(e.getSource())).position);
                }
            });
    }
  }
}