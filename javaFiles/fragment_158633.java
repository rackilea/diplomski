import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        Set<Integer> exclude = new HashSet<>();
        exclude.add(4);
        exclude.add(6);
        exclude.add(7);
        for (int[] arr : getRandomMatrix(10, 15, exclude)) {
            for (int i : arr) {
                System.out.println("rnd: " + i);
            }
        }
    }

    public static int[][] getRandomMatrix(int cantidad, int range, Set<Integer> excludeNumbers) {
            int[][] Matriz2 = new int[1][cantidad];

            Set<Integer> randomNumbers = new HashSet<>();
            while (randomNumbers.size() < cantidad) {
                int randomNumber = -1;
                while(randomNumber == -1 || excludeNumbers.contains(randomNumber)) {
                    randomNumber = (int) (Math.random() * range);
                }
                randomNumbers.add(randomNumber);
            }

            List<Integer> list = new ArrayList<>(randomNumbers);
            for (int i = 0; i < list.size(); i++) {
                Matriz2[0][i] = list.get(i);
            }
            return Matriz2; 
    }
}