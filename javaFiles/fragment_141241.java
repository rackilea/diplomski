System.out.close();
try{
    int a = 1 / 0;
} catch(ArithmeticException e){
    System.out.print("Hi");
} finally {
    System.out.print("It's me again...");
}