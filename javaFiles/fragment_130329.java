import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

public class PerfTest {
    public static double hashNum = 0;
    public static double arrayNum = 0;

    public static class PerfBenchmark extends SimpleBenchmark {
        static java.util.HashMap<String, Double> map;
        static Double[] array = {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0};

        static{
            map = new java.util.HashMap<String, Double>();
            map.put("1",    new Double(1));
            map.put("2",    new Double(2));
            map.put("3",    new Double(3));
            map.put("4",    new Double(4));
            map.put("5",    new Double(5));
            map.put("6",    new Double(6));
            map.put("7",    new Double(7));
            map.put("8",    new Double(8));
            map.put("9",    new Double(9));
            map.put("10",   new Double(10));        
        }

        public void timeHashMap(int nTimes){
            int sz = map.size();

            String key = "1";   

            for (int i=0; i <nTimes; i++){
                double sum = 0; 

                for (int j =1; j<=sz; j++){
                    sum += map.get(key);                            
                }

                hashNum += sum;
            }
        }

        public void timeArray(int nTimes){
            for (int i=0; i <nTimes; i++){
                double sum = 0;

                for (int j=0; j< array.length; j++) {       
                    sum += array[j];
                }

                arrayNum += sum;
            }
        }
    }

    public static void main(String[] args){
        Runner.main(PerfBenchmark.class, new String[0]);

        System.out.println(hashNum);
        System.out.println(arrayNum);
    }
}