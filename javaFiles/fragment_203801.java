boolean done = false;
while(!done) {
    System.out.println("Please enter the width of the rectangle");
    w = input.nextFloat();
    done = myRectangle.isValidWidth(w); 
}
myRectangle.setWidth(w);