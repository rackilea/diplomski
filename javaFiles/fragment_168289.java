int op = 0;
    while(op != -1) {
        double num1, num2;
        Scanner operation = new Scanner(System.in);
        System.out.println("1 - Add\n2 - Subtract\n3 - Multiply\n4 - Divide");
        System.out.print("Which operation would you like to perform?   ");
        op = operation.nextInt();

        if((op != 1) && (op != 2) && (op != 3) && (op != 4)){
            System.out.println("That wasn't an option...");
        }else{
            System.out.print("First number:   ");
            num1 = operation.nextDouble();
        System.out.print("Second number:   ");
            num2 = operation.nextDouble();


            if(op==1){
                Add(num1, num2);
            }else if(op==2){
                Sub(num1, num2);
            }else if(op==3){
                Mult(num1, num2);
            }else if(op==4){
                Div(num1, num2);
            }
    }