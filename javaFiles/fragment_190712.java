public class Main{

    public static void main(String[] args) {

        boolean correctAnswer;
        int nmb1;
        int nmb2;
        int multi;

        // It computes all combinations
        List<int[]> asks = new ArrayList<>(100);
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                asks.add(new int[]{i,j});
            }
        }

        // It shufles
        Collections.shuffle(asks);

        // It asks for every number pair
        for (int[] numbers : asks){ // instead of while(true)
            nmb1 = numbers[0];
            nmb2 = numbers[1];
            multi = nmb1 * nmb2;

            // read the user's input ...

            ...
        }