public static void main(String[] args) {

    Scanner input = new Scanner( System.in ); 
    System.out.println("Enter your annual sales");
    String annual = input.nextLine();

    int salary = 7550281; 
    int com = 3828; 
    int compensation = Integer.parseInt(annual) * com + salary;

}