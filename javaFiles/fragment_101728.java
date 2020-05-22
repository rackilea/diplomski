import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


public class MultiValueMapExample {

    public static void main(String[] args) {
        // 10-a, 10-b, 9-c, 8-d, 8-e, 8-f, 4-g, 4-h, 2-i
        MultiValueMap<Integer, String> map = new LinkedMultiValueMap<Integer, String>();
        map.add(8, "g");
        map.add(4, "h");
        map.add(10, "a");
        map.add(10, "b");
        map.add(9, "c");
        map.add(8, "d");
        map.add(8, "e");
        map.add(8, "f");

        map.add(2, "i");

        System.out.println(map.toString());
        // {8=[g, d, e, f], 4=[h], 10=[a, b], 9=[c], 2=[i]}

        MultiValueMap<Integer, String> filteredMap = filter(5, map);
        System.out.println( filteredMap.toString() );
        // {10=[a, b], 9=[c], 8=[g, d, e, f], 4=[h], 2=[i]}

    }

    public static MultiValueMap<Integer, String> filter(int numberOfResults, MultiValueMap<Integer, String> map){
        MultiValueMap<Integer, String> result = new LinkedMultiValueMap<Integer, String>();

        List<Integer> keys = new ArrayList<Integer>(map.keySet());
        Collections.sort(keys, Collections.reverseOrder());

        for(Integer key : keys){
            if( result.size() <= numberOfResults ){
                result.put(key, map.get(key));
            }else{
                break;
            }
        }

        return result;

    }
}