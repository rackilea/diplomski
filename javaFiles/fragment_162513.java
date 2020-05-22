public class Test {

    public static void main(String[] args) {
        Test x = new Test();
        x.generatePermutations(2, 3, 1);
    }

    private void generatePermutations(int intervalOne, int intervalTwo,
            int intervalThree) {
        for (int i = 0; i <= intervalOne; i++) {
            for (int j = 0; j <= intervalTwo; j++) {
                for (int k = 0; k <= intervalThree; k++) {
                    System.out.print(i + "" + j + "" + k + " ");
                }
            }
        }
    }
}