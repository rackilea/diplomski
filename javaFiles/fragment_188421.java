static int integerone, integertwo; // make them static to access in a static context
... // other code
while (number<3){
    System.out.println("Type in integer "+number+":");
    if (number<2)
    {
       integerone = kbinput.nextInt(); //no int keyword
    }
    number++;
}
integertwo = kbinput.nextInt(); // no int keyword