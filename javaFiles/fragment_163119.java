public static void dfs(int[][] matrix) {
    boolean[] visited = new boolean[matrix.length];

    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(0);

    while (!stack.isEmpty()) {
        int v = stack.pop();
        if (!visited[v]) {
            System.out.print("\n" + (v + 1));
            visited[v] = true;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[v][i] == 1 && !visited[i]) {
                visited[i] = true;
                stack.push(v);
                v = i;
                System.out.print(" " + (i + 1));
            }
        }
    }
}