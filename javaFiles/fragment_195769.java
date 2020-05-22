public class Tester {

    public static void main(String[] args){
         int[] values = {0,0,0,0,1,1,1,1,0,0,0,0,2,2,2,2,3,3,3,3,0,0,0,0};

         List<Integer> output = new ArrayList<Integer>();
         if(values.length > 0){
            int previous = values[0];
            output.add(previous);
            for(int value : values){
                if(previous != value){
                    output.add(value);
                }
                previous = value;
            }
         }
         System.out.println(output); // [0, 1, 0, 2, 3, 0]
    }
}