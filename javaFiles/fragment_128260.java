import com.fasterxml.jackson.databind.ObjectMapper;//<--IMPORTANT!

public class TestJacksonObject {


     public static void main(String[] args) {


         ObjectMapper mapper =  new ObjectMapper(); 
         ExampleStack stack = null;
            try {
                stack = mapper .readValue( new FileInputStream(new File("C://test.json")) , ExampleStack.class);

            } catch (IOException e) {
                e.printStackTrace();
            }

    System.out.println(stack.message);//<--Do whatever you want...
.....