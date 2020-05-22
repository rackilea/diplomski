import java.util.*;

public class GridColouring {

    public static int getStrokes(String [] grid) {
        int N = grid.length;
        int M = grid[0].length();
        HashSet<Integer> hr = new HashSet<>();
        HashSet<Integer> v = new HashSet<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            String row = grid[i];
            row = row.toUpperCase();
            for (int j = 0; j < M; j++) {
                // Precedence of 'and' greater than 'or'
                if (row.charAt(j) == 'G' || (row.charAt(j) == 'R' && !hr.contains(i))) {
                    hr.add(i);

                } else if (hr.contains(i)) {
                    if (j > 0 && grid[i].charAt(j - 1) == 'B') {
                        count++;
                    }
                }
                if (row.charAt(j) == 'G' || (row.charAt(j) == 'B' && !v.contains(j))) {
                    v.add(j);
                } else if(v.contains(j)) {

                    if (i > 0 && grid[i-1].charAt(j) == 'R') {
                        count++;
                    }
                }
            }
        }
        int horStrokes = hr.size();
        int verStrokes = v.size();

        int minStrokes = horStrokes + verStrokes + count;
        return minStrokes;
    }
    public static void main(String [] args) {

        String [] a = {"GR.","BG.","RBR","BBB"};
        System.out.println(getStrokes(a));
    }
}