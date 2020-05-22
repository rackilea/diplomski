public static void main(String args[])
{
    ClassA objA = new ClassA();
    ClassC objC = new ClassC();
    objA.displayA(); //fine
    objC.displayC(); //fine
    System.out.println(objC.m); //Not Allowed, prevented by protected access
}