public void setUpVariables(int x) {
    int xLocation = (x + 10)/70;
    mover.placePiece(xLocation);
    setMouseX(xLocation);
    System.out.println("Place piece at " + mouseX + ", " + mover.getRow() + ".");
}