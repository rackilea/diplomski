public class Main {
    // Maintain a global counter. After finding a permutation, increment this. 
    private static int count = 0;

    // pos is the current index, and K is the length of permutation you want to print, and N is the number of permutation you want to print.
    private static void printPermutations(int[] arr, int[] visited, int pos, int K, int N, String str) {

        // We have already found N number of permutations. We don't need anymore. So just return.
        if (count == N) {
            return;
        }

        if (pos == K) {
            System.out.println(str);
            count++; // we have found a valid permutation, increment counter.
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // Only recur if the ith element is not visited.
            if (visited[i] == 0) {
                // mark ith element as visited.
                visited[i] = 1;
                printPermutations(arr, visited, pos + 1, K, N, str + arr[i]);
                // unmark ith element as visited.
                visited[i] = 0;
            }
        }

    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] visited = {0, 0, 0, 0}; // same as size of input array.
        count = 0; // make sure to reset this counter everytime you call printPermutations.
        // let's print first 4 permutations of length 3.
        printPermutations(arr, visited, 0, 3, 4, "");
    }
}