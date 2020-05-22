public void condenceTiles(){
  for (int i = 15; i > 0; i--){
    for(int j = 0; j < 8; j++){
      if(_tiles[j][i] == null && _tiles[j][i-1] != null) {
        _tiles[j][i] = _tiles[j][i-1];
        _tiles[j][i-1] = null;
      }
    }
  }
  repaint();
}