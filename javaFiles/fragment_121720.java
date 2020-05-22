double width;
if(in.hasNextDouble()){
    width = in.nextDouble();
    System.out.println("Width/Height: " + width);
} else {
    throw new IllegalArgumentException("Please enter only numbers");
}