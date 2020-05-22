public Triangle( OutputBox oBox, MainWindow mWindow ) {
    this.theBase=0;
    this.theHeight=0
    this.theArea=0;                                         
  }
  public void calculateArea() {                                           
    InputBox iBox = new InputBox(mWindow);
    this.theBase = iBox.getDouble("Please enter the length of the base of the triangle ");
    this.theHeight = iBox.getDouble("Please enter the height of the triangle");
    computeArea();
    oBox.println(" The area of a triangle of base : " + this.theBase+ " and height : " + this.theHeight +" is equal to : "+ this.theArea  );
  }
}