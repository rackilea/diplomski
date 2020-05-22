public void linkToThisWall(Wall another) {
    assert this.height == another.height : "Walls have unequal height";
    if (!this.isComplete() || !another.isComplete()) {
        return; // or maybe throw an exception?
    }        
    int w = this.width + another.width;
    int h = this.height;
    Brick[][] newBricks = new Brick[w][h];
    System.arraycopy(this.bricks, 0, newBricks, 0, this.width);
    System.arraycopy(another.bricks, this.width, bricks, 0, another.width);
    this.bricks = newBricks;
}