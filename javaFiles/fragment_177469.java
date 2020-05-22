public static void main(String[] args) {
                                       ^--- This is important...
    Scanner input = new Scanner( System.in); 
                                          ^--- Also important :P
    BufferReader br = new BufferReader(instream);

    System.out.println("Enter your annual sales");
    String annual = br.readLine();

    int salary = 75_502_81; 
    int com = 38_28; 
    int compensation = annual * com + salary;
}