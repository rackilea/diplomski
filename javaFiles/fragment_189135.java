public static void stackRPN(){
    Stack myStack = new Stack();

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter an equation: ");
            System.out.println();
            String eq = sc.nextLine();

            //This Bit splits up the string where it meets a space

            String[] eqS = eq.split(" ");
            int len = eqS.length;


            for (int i = 0; i < len; i++){
                String car1 = eqS[i];

                if ("+".equals(car1) || "-".equals(car1) || "/".equals(car1) || /*"car1"*/"x".equals(car1)){   
                String a = myStack.pop();
                String b = myStack.pop();                    

                //This handlws all the digits
                double bI = Double.parseDouble(b);
                double aI = Double.parseDouble(a);
                double finalNo = 0;

                switch (car1) {
                    case "+":  finalNo = bI + aI;
                             break;
                    case "-":  finalNo = bI - aI;
                             break;
                    case "/":  finalNo = bI / aI;
                             break;
                    case "x":  finalNo = bI * aI;
                             break;
               }   


                myStack.push(finalNo+""); 

                String finEq = b+car1+a;
                System.out.println(finEq + " = " +finalNo);

                } else {
                myStack.push(car1);
                }
            }
               mainMenu(); 
    }