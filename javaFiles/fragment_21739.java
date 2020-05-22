public static void main(String[] args) {
        String s1 = getInput("Enter a number: ");
        String s2 = getInput("Enter a number: ");

        //notice I declare this outside now so I can compute for new value inside loop
        int opInt = 0;
        double result = 0;

        //you can change the condition later if you add more options
        while(opInt < 1 || opInt > 4) {
            String op = getInput("Enter: 1 = Add, 2 = Subtract, 3 = Multiply, 4    = Divide ");
            //recalculate the choice
            opInt = Integer.parseInt(op);

            switch (opInt) {
                case 1:
                    result = addValues(s1, s2);
                    break;
                case 2:
                    result = subtractValues(s1, s2);
                    break;
                case 3:
                    result = multiplyValues(s1, s2);
                    break;
                case 4:
                    result = divideValue(s1, s2);
                    break;
                default:
                    System.out.println("the value doesn't exist.");
                    break;
            }
        }
        System.out.println(result);
    }