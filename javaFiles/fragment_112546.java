public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    String date = null;
    String tec = null;

    System.out.println("Enter name for test file :");
    String file = input.nextLine();

    System.out.println("Enter date formatted as dd/mm/yyyy hh:mm :");
    date = input.nextLine(); //String 2 parts

    System.out.println("Enter technician name :");
    tec = input.nextLine(); // String 2+ parts
}