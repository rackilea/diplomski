public SimonLight(Color defCol, Color lightUpCol, Orientation orient, int x, int y){
    super(x, y, 200, 200, 90, 90, Arc2D.PIE);
    this.defCol = defCol;
    this.color = defCol;
    this.lightUpCol = lightUpCol;
    this.orient = orient;
}