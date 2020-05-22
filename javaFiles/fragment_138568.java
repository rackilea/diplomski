import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<List<Integer>> data = readFile("C:\\Users\\Nick\\Desktop\\test.txt");
        for (List<Integer> row : data)
            System.out.println(row);
        final int n = data.size();
        int maxVertical = getVertical(data);
        int maxHorizontal = getHorizontal(data, n);
        int maxDiagonal = getDiagonal(data, n);
        int maxAntiDiagonal = getAntiDiagonal(data, n);
        System.out.println("max vertical = " + maxVertical);
        System.out.println("max horizontal = " + maxHorizontal);
        System.out.println("max diagonal = " + maxDiagonal);
        System.out.println("max anti-diagonal = " + maxAntiDiagonal);
    }
    public static int getVertical(final List<List<Integer>> list) {
        int result = 0;
        for (List<Integer> arr : list) {
            int curr = 0;
            for (Integer val : arr)
                curr += val;
            if (curr > result)
                result = curr;
        }
        return result;
    }
    public static int getHorizontal(final List<List<Integer>> list, final int len) {
        List<Integer> sums = new ArrayList<Integer>(list.get(0));
        for (int i = 1; i < len; ++i)
            for (int j = 0; j < len; ++j)
                sums.set(j, sums.get(j) + list.get(i).get(j));
        return Collections.max(sums);
    }
    public static int getDiagonal(final List<List<Integer>> list, final int len) {
        int result = 0;
        // [top half]
        for (int i = len - 1; i > 0; --i) {
            int tmp = 0;
            for (int j = 0, x = i; x <= len - 1; ++j, ++x) {
                final int val = list.get(x).get(j);
                tmp += val;
            }
            if (tmp > result)
                result = tmp;
        }
        // [lower half]
        for (int i = 0; i <= len - 1; ++i) {
            int tmp = 0;
            for (int j = 0, y = i; y <= len - 1; ++j, ++y) {
                final int val = list.get(j).get(y);
                tmp += val;
            }
            if (tmp > result)
                result = tmp;
        }
        return result;
    }
    public static int getAntiDiagonal(final List<List<Integer>> list, final int len) {
        int result = 0;
        // [top half]
        for (int k = 0; k < len; ++k) {
            int tmp = 0;
            for (int j = 0; j <= k; ++j) {
                int i = k - j;
                int val = list.get(i).get(j);
                tmp += val;
            }
            if (tmp > result)
                result = tmp;
        }
        // [lower half]
        for (int k = len - 2; k >= 0; --k) {
            int tmp = 0;
            for (int j = 0; j <= k; ++j) {
                int i = k - j;
                int val = list.get(len - j - 1).get(len - i - 1);
                tmp += val;
            }
            if (tmp > result)
                result = tmp;
        }
        return result;
    }
    public static List<List<Integer>> readFile(final String path) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Path p = Paths.get(path);
        if (!Files.exists(p))
            return null;
        List<String> lines = null;
        try {
            lines = Files.readAllLines(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (lines == null)
            return null;
        for (String str : lines) {
            List<Integer> row = new ArrayList<Integer>();
            final String line = str.substring(1, str.length() - 1);
            String[] arr = line.split(" ");
            for (String s : arr)
                row.add(Integer.valueOf(s.trim()));
            result.add(row);
        }
        return result;
    }
}