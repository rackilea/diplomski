import java.util.Arrays;
import java.util.List;
import  java.util.stream.IntStream;

public class Stream1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3,4);

        int [][] int2DArray = IntStream.range(1, list.size())
                .mapToObj(i -> new int[] {list.get(i-1), list.get(i)})
                .toArray(int[][]:: new);

        System.out.println(Arrays.deepToString(int2DArray));
    }
}