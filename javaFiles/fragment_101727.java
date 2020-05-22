import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


public class MultiValueMapExample {

    public static void main(String[] args) {
        // 10-a, 10-b, 9-c, 8-d, 8-e, 8-f, 4-g, 4-h, 2-i
        MultiValueMap<Integer, String> map = new LinkedMultiValueMap<Integer, String>();
        map.add(10, "a");
        map.add(10, "b");
        map.add(9, "c");
        map.add(8, "d");
        map.add(8, "e");
        map.add(8, "f");
        map.add(8, "g");
        map.add(4, "h");
        map.add(2, "i");

        System.out.println(map.toString());
        // {10=[a, b], 9=[c], 8=[d, e, f, g], 4=[h], 2=[i]}
    }
}