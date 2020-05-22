public class Main {
    public static void main(String[] args) {
        int j = 1;
        int k = 0;


        for(int i = 0; i < 40; i++) {

            System.out.println("quizAnswerSTORE"+i+".setText(answerStoration.retrieveDataChoices("+j+",TB).get("+k+"));");
            k = (k + 1)%4;

            if( k == 0) {
                j = (j+1) % 11;
            }

        }

    }
}