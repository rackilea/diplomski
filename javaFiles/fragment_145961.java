public static void main(String[] args){

   int x = getFromPropertyFile();
   Shape shape = getShape(x); // Shape obtained from a factory method
   shape.draw(); //Runtime polymorphism
}