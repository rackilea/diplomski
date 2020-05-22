import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        //Test
        List<String> foods=Arrays.asList("Fried Fries","Meat Bal");
        System.out.println(feedBack(foods));
    }
    public static List<ArrayList> feedBack(List<String> foods){
        int foodType;
        int rating;
        List<ArrayList> ratingOfAllFoods=new ArrayList<ArrayList>();
        List<Integer> ratingOfFriedFries=new ArrayList<Integer>();
        List<Integer> ratingOfMeatBall=new ArrayList<Integer>();
        for(int i=0;i<foods.size();i++)        {
            System.out.printf("%s%n",foods.get(i));
            System.out.print("Please rate that food out of 5: ");
            Scanner feedback=new Scanner(System.in);
            if(feedback.hasNextInt()) {
                rating=feedback.nextInt();
                if ("Fried Fries".equals(foods.get(i))) {
                    ratingOfFriedFries.add(rating);
                    ratingOfAllFoods.add((ArrayList) ratingOfFriedFries);
                }
                else if("Meat Bal".equals(foods.get(i))){
                    ratingOfMeatBall.add(rating);
                    ratingOfAllFoods.add((ArrayList) ratingOfMeatBall);
                }
              } else {
                  System.out.println("Invalid input");
              }
        }
        return ratingOfAllFoods;
    }
}