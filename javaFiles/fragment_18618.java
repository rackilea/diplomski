import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        String[] words = {"cat","dog", "rat", "pet", "bat"};
        String[] numbers = {"1","2", "3", "4", "5"};

        Map<String,String> keyval = new HashMap<String,String>();

        for(int  i = 0 ; i < words.length ; i++ ){
            keyval.put(words[i], numbers[i]);
        }

        String searchKey = "rat";

        if(keyval.containsKey(searchKey)){
            System.out.println(keyval.get(searchKey));
        }
    }

}