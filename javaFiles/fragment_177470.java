public static void main(String[] args) {

    Scanner input = new Scanner( System.in ); 
    BufferedReader br = null;

    try {
        br = new BufferedReader(instream);
        System.out.println("Enter your annual sales");
        String annual = br.readLine();

        int salary = 7550281; 
        int com = 3828; 
        int compensation = Integer.parseInt(annual) * com + salary;

    } catch (IOException exp) {
        exp.printStackTrace();
    } finally {
        try {
            br.close();
        } catch (Exception exp) {
        }
    }
}