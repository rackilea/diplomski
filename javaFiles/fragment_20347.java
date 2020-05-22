import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class TestClass {
    public static void main(String args[] ) throws Exception {

        //Scanner
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int x=sc.nextInt();
            Integer value = map.get(x);
            if(x < k){
                if(value == null) {
                    map.put(x, 1);
                }
                else if(value<=1) map.put(x,2);
            }
        }
        ;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            Integer key = entry.getKey();
            if(k>=key && map.containsKey(k-key)) {
                //check if same key
                if(k - key == key){
                    if(map.get(key)>1) {
                        System.out.println("YES");
                        return;
                    }
                }
                else {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");

    }
}