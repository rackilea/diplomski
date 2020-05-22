public class Grade {

    //New method
    public int getIntegerInput() throws NotANumberException {
        Scanner input = new Scanner(System.in);
        try {
           return input.nextInt();
        } catch( InputMismatchException e) {
            throw new NotANumberException();
        }
    }

    public static void main(String args[]){

        int grade;
        String remark;
        try{
            System.out.print("Enter Grade: ");
            grade = getIntegerInput();
        }
        catch(NotANumberException e){
            System.out.println(e.notgetMessage());
        }
    }
}