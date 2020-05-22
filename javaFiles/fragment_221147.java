import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static int[] dx = {-1,0,1}, dy = {1,1,1};
    public static List<List<Integer>> dfsForAllPaths(int[][] grid) {
        List<List<Integer>> res = new ArrayList<>();
        if(grid == null) {
            return res;
        }
        for(int i = 0; i < grid[0].length; i++) {
            dfsHelper(grid, i, 0, res, new ArrayList<>());
        }
        return res;
    }

    private static void dfsHelper(int[][] grid, int x, int y, List<List<Integer>> res, List<Integer> list) {
        if(!isInBound(grid, x, y)) {
            return;
        }
        list.add(grid[x][y]);
        if(y == grid[0].length - 1) {
            res.add(new ArrayList<>(list));
        }
        for(int dir = 0; dir < 3; dir++) {
            int newX = x + dx[dir], newY = y + dy[dir];
            dfsHelper(grid, newX, newY, res, list);
        }
        list.remove(list.size() - 1);
    }

    private static boolean isInBound(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        List<List<Integer>> res = dfsForAllPaths(grid);
        for(int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}