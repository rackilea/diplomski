if(side1 < (side2 + side3) && side2 < (side1 + side3) && side3 < (side1 + side2)){ 
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;

} else {
    System.out.println("Invalid side lengths!");
}