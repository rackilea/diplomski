public class HelloWorld{

     public static void main(String []args){
        String name1 = "John Papa P";
        String name2 = "Michael Jackson";

        String[] split = name1.split(" ");

        String result;
        if (split.length > 2) {
            result = split[1] + ", " + split[0] + " " + split[2];
        } else {
            result = split[1] + ", " + split[0];
        }

        System.out.println(result);
     }
}