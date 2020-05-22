public static void main(String[] args) {
        // TODO code application logic here  
        Scanner input = new Scanner(System.in);

        final String payment = input.next();
        if(payment.startsWith("$") && payment.matches(".*\\.\\d\\d"))
        {
           double paymentConverted = Double.parseDouble(payment.substring(1));
           // write ur others logic here
        }
        else
        {
             System.out.println("Invalid text !");
        }  
    }