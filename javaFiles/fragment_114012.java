import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Scratch {
    static List<String> list = Arrays.asList("A", "B", "C", "D");

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            result.addAll(restList(list.get(i), list.subList(i + 1, list.size())));
        }
        System.out.println(Arrays.toString(result.toArray()));
    }

    static List<String> restList(String input, List<String> inputList) {
        List<String> restList = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            String x = input + inputList.get(i);
            restList.add(x);
            restList.addAll(restList(x, inputList.subList(i + 1, inputList.size())));
        }
        return restList;
    }
}