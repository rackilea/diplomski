public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);
    boolean valid = false;
    while(!valid) {
        System.out.println("How many tickets do you want?");

        try {
            int number = keyboard.nextInt();
            if(number < 1) throw new LottoLimitException();
            for (int i = 0; i < number; i++)
                printTicket(generateNumber());

            valid = true;
        } catch (LottoLimitException e) {  //number is less than 1
            valid = false;
            System.out.println(e.getMessage());
        } catch (Exception e) { //will get here for any other exception, such as invalid number
            valid = false;
            System.out.println("Invalid Format");
        }
    }
}