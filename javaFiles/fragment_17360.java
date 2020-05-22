public class Main {

    @FunctionalInterface
    public interface Func {
        void call(int[] arr, int i, int j);
    }

    public static void main(String[] args) {
        int[] numbers = {45, 123, 12, 3, 656, 32};
        System.out.println("Unsorted array: " + Arrays.toString(numbers));

        // store swap function as a lambda to avoid code duplication
        Func swap = (int[] arr, int i, int j) -> {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        };

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(numbers.length);

        while (!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.pop();
            if (end - start < 2) {
                continue;
            }

            // partitioning part
            int position = start + ((end - start) / 2);
            int low = start;
            int high = end - 2;
            int piv = numbers[position];
            swap.call(numbers, position, end - 1);
            while (low < high) {
                if (numbers[low] < piv) {
                    low++;
                } else if (numbers[high] >= piv) {
                    high--;
                } else {
                    swap.call(numbers, low, high);
                }
            }
            position = high;
            if (numbers[high] < piv) {
                position++;
            }
            swap.call(numbers, end - 1, position);
            // end partitioning part

            stack.push(position + 1);
            stack.push(end);
            stack.push(start);
            stack.push(position);
        }

        System.out.println("Sorted array: " + Arrays.toString(numbers));
    }
}