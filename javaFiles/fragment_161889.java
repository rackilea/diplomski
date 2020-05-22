public class Pattern{

    private static final int MAX_LINE_LENGTH = 13;
    private static final int MIN_LINE_LENGTH = 9;
    private static final int DIFFERENCE = 2;
    private static final int LINES = 5;

    private static final String SPACE = " ";
    private static final String STAR = "*";

    public static void main(String[] args) {
        printPattern();
    }

    private static void printPattern(){
        int spaces = 0;
        int stars = MAX_LINE_LENGTH;
        boolean reverse = false;

        for (int i=0; i<LINES; i++) {
            printLine(spaces,stars);

            if (stars == MIN_LINE_LENGTH) {
                reverse = true;
            }

            if (reverse == false) {
                spaces+=DIFFERENCE;
                stars-=DIFFERENCE;  
            }else{
                spaces-=DIFFERENCE;
                stars+=DIFFERENCE;
            }       
        }
    }

    private static void printLine(int spaces, int stars){
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<spaces+stars; i++) {
            if (i<spaces) {
                builder.append(SPACE);      
            }else{
                builder.append(STAR);               
            }
        }
        System.out.println(builder.toString());
    }
}