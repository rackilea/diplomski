public class Example2{
    public static void main(String args[]){

        FileIO reader = new FileIO();
        Scanner scan = new Scanner(System.in);

        String[] inputs = reader.load("C:/ratings.csv");
        String[][] sep = new String[inputs.length][];

        for(int i=0;i<inputs.length;i++){
             sep[i]=inputs[i].split(",");
             System.out.println(Arrays.toString(sep[i]));
           }
        }

        // ... 
    }
}