Scanner input=new Scanner(System.in);

    String name = "";
    double gpa = 0;
    boolean correctNameEnetered = false;
    boolean correctGPAEneterd  = false;

    while(true){
         try {
             if(!correctNameEnetered){
                 System.out.println("Enter ur name");
                 name=input.nextLine();
                 correctNameEnetered = true;
             }
         }catch(InputMismatchException ex) {
            System.out.println("Please provide String value for name");
            continue;
         }
         try {
             if(!correctGPAEneterd) {
                System.out.println("enter ur gpa");
                gpa = Double.parseDouble(input.next()); 
                correctGPAEneterd = true;
             }
         }catch(NumberFormatException  ex) {
            System.out.println("Please provide an integer or decimal value for gpa");
            continue;
         }
         break;

    }

    System.out.println("Hi"+name+",ur gpa is "+ gpa);