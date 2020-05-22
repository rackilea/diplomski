try {
            double tempValue = scan.nextDouble();

            //this loop will keep spinning, until tempValue is valid
            while (tempValue > 100d || tempValue < 0d) {
                System.out.println("Invalid. Try again. Range is 0 - 100");
                tempValue = scan.nextDouble();
            }
            //this loop will spin forever (There is nothing to terminate it)
            while (true) {

                double sumFocus = 0;
                double[] arrayFocus = new double[2];

                for (int i = 0; i < 2; i++) {
                    arrayFocus[i] = scan.nextDouble();
                }
                for (double num : arrayFocus) {
                    sumFocus = sumFocus + num;
                }
            }
        }
        catch (InputMismatchException e) {

            System.out.println("Invalid input");
            scan.nextDouble(); //this doesn't do anything. The value is not assigned to any variable
        }