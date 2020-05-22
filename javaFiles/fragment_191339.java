public void accept(Brick brick) { // Lay a brick into THIS wall
    this.lay(brick);
}

public void combine(Wall wanother) { // Combine another wall with THIS wall
    this.linkToThisWall(another);
}