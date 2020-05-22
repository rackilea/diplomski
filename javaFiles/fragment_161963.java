public class SumProblem {
    public static List<List<Integer>> find(List<Integer> input, int requiredSum) {
        List<List<Integer>> result = new ArrayList<>();
        find(result, requiredSum, 0, new ArrayList<>(), 0, input);
        return result;
    }

    public static void find(List<List<Integer>> result, int requiredSum, int currentSum,
            List<Integer> partialResult, int i, List<Integer> input) {
        if (currentSum == requiredSum) {
            result.add(new ArrayList<>(partialResult)); // add a copy of the list
            return;
        }

        if (i >= input.size()) {
            return;
        }
        // make defensive copies in the recursive calls
        find(result, requiredSum, currentSum, new ArrayList<>(partialResult), i + 1, input);
        partialResult.add(input.get(i));
        find(result, requiredSum, currentSum + input.get(i), new ArrayList<>(partialResult), i + 1, input);
    }

    public static void main(String[] args) {
        List<Integer> input = List.of(2, 8, 2, 3, 4);
        List<List<Integer>> output = find(input, 7);
        System.out.println(output);
    }
}