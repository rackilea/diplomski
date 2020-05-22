public class Main {

    /** Creates a new instance of Main */
    public Main() {
    }

    public static enum RepeatType {
        DAILY, WEEKLY, MONTHLY;
    }    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RepeatType r1;
        r1 = RepeatType.DAILY;
        System.out.printf("R1 VALUE: %s\n", r1.toString());

        r1 = RepeatType.WEEKLY;
        System.out.printf("R1 VALUE: %s\n", r1.toString());

        r1 = RepeatType.MONTHLY;
        System.out.printf("R1 VALUE: %s\n", r1.toString());


    }

}