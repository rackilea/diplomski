public static void main(String [] args){
    Conversion convertThisVal = new Conversion();
    Scanner typeOne = new Scanner(System.in);
    Scanner typeTwo = new Scanner(System.in);
    Scanner valueOne = new Scanner(System.in);
    System.out.println("Convert From: ");
    String newTypeOne = typeOne.next();
    System.out.println("To: ");
    String newTypeTwo = typeTwo.next();
    System.out.println("Enter the values!");
    double newValueOne = valueOne.nextDouble();

    System.out.println("cm:" + convertThisVal.convert(newTypeOne,newTypeTwo, newValueOne ));
}