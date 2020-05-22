public class Sample{ 
         public static void main(String []args){
            String value = "3,22"; 
            Double d = Double.parseDouble(value.replace(",",".")); 
            System.out.println(d); 
         }
    }