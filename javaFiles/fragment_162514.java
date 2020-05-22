public class Test {

    public static void main(String[] args) {
        Test x = new Test();
        int[] intervals = { 1, 1, 1, 1, 1 };
        x.generatePermutations(intervals);
    }

    private void generatePermutations(int[] intervals) {
        generatePermutations(intervals, 0, "");
    }

    private void generatePermutations(int[] intervals, int intpos,
            String lastPerm) {

        if (intpos == intervals.length)
            return;

        for (int i = 0; i <= intervals[intpos]; i++) {
            if (intpos == intervals.length - 1) {
                System.out.print(lastPerm + i + " ");
            }
            generatePermutations(intervals, intpos + 1, lastPerm + i);
        }
    }
}