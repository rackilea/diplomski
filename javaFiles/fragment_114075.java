public class ReadInput {
    public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String x = null;  
        while( (x = input.readLine()) != null ) {    
            System.out.println(x); 
        }    
    }
}