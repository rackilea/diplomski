public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many numbers do you want to divide? ");

        int division = input.nextInt();
        double[] divisionArray = new double[division];

        for(int i = 0; i < division; i++) {
            System.out.print("Enter your " + (i + 1) + ". number: ");
            divisionArray[i] = input.nextDouble();
        }

        //remember the first value and divide it trough the second, 
        //third, fourth and so on...
        double result = divisionArray[0];
        for(int k = 1; k < division; k ++) {
            result = result / divisionArray[k];
        }
        System.out.println("Result: " + result);
    }