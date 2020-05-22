public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter positive integers. Enter -1 to stop. ");
        int number = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        do{
            if(scan.hasNextInt()){
                number = scan.nextInt();

                if(number < -1){
                    System.out.println("Invalid input. Try again.");
                }else if(number > -1){
                    sum += number;
                    sb.append(number + ", ");
                }
            }else{
                System.out.println("Invalid input. Try again.");
                scan.next(); // reset the scanner
            }
        }while (number != -1);

        System.out.println("Numbers entered: " + sb.delete(sb.length() - 2, sb.length()) + ".");
        System.out.println("The sum: " + sum + ".");
}