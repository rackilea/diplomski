import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

class TestClass {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());

        //go through all test cases
        for (int i = 0; i < t; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            String[] inputs = br.readLine().split(" ");
            int N = Integer.parseInt(inputs[0]);
            int Q = Integer.parseInt(inputs[1]);
            inputs = br.readLine().split(" ");

            //read array
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(inputs[j]);
                Integer value = map.get(x);
                //if number is already in hashmap then increment its count
                //else put it into the map with a count of 1
                if (value == null) {
                    map.put(x, 1);
                } else map.put(x, value + 1);
            }

            //iterate through the queries and get their occurences from the map
            for (int j = 0; j < Q; j++) {
                int x = Integer.parseInt(br.readLine());
                Integer value = map.get(x);
                if (value == null) {
                    pr.println(0);
                } else pr.println(value);
            }
        }
        pr.close();
    }
}