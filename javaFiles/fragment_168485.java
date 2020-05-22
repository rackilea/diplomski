import java.util.Random;
public class HelloWorld{

 public static void main(String []args){
    Double[] percentages = {52.3, 7.7, 20.0, 20.0};
    int index = pickRandom(percentages);
    System.out.println(index);

 }

 public static int pickRandom(Double[] list) {
    // Returns random index of list 
     Random r = new Random();
     Double randomPercentage = r.nextDouble() * 100;
     double sum = 0;
     int index = 0;
     for(Double d : list) {
         sum += d;
         if(sum > randomPercentage) {
             return index;
         }
         index += 1;
     }
     return index;
 }
}