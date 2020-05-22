import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewClass {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(18, 21, 9, 12, 99, 4, 101, 8, 14, 7, 112, 98);

        List<List<Integer>> chunks = breakIntoChunks(intList);

        for(List<Integer> chunk : chunks){
            System.out.println(chunk);
        }
    }

    private static List<List<Integer>> breakIntoChunks(List<Integer> intList) {
        List<List<Integer>> chunks = new ArrayList<>();
        int curr =0;
        for(int i = 0; i<intList.size()-1; i++){
            if(intList.get(i).compareTo(intList.get(i+1))>0 || i==intList.size()-1){
                chunks.add(intList.subList(curr, i+1));
                curr = i+1;
            }
         }
         if(curr<=intList.size()){
              chunks.add(intList.subList(curr,intList.size()));
         }
         return chunks;       
      }
  }