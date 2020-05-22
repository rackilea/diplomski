for(int i = 0; i < 4; ++i) {
   Player0Positions[i] = new Dimension();
   Player0Positions[i].setSize(bufferArray[(2*i)], bufferArray[(2*i + 1)]);
   Player1Positions[i] = new Dimension();
   Player1Positions[i].setSize(bufferArray[(2*i + 8)], bufferArray[(2*i + 9)]);
}