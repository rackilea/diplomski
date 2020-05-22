import java.util.*;
public class Prog310t
{
    public static Integer randomNumbers (int minNumber, int maxNumber)
    {
        Random gen = new Random();
        return (gen.nextInt(maxNumber - minNumber + 1) + minNumber);
    }

    public static String starLine (int numberOfAsterisks)
    {
        String stars = "";
        for (int i = 0; i < numberOfAsterisks; i++)
            stars = stars + "*";
        return stars;
    }

    public static void main (String args [])
    {
        int days = 1;
        for(int week = 0; week < 5; week++){
            for(int day = 1; day < 8 && days < 32; day++){
                int randomNumber = 0;
                    if(day==1){
                        randomNumber = 0;
                    }else if(day == 2){
                        randomNumber = randomNumbers(30000, 40000);
                    }else if(day==3){
                        randomNumber = randomNumbers(20000, 40000);
                    }else if(day==7){
                        randomNumber = randomNumbers(10000, 15000);
                    }else{
                        randomNumber = randomNumbers(10000, 40000);
                    }
                System.out.println(days + "\t" + randomNumber + "\t" + starLine(randomNumber / 1000));
                days++;
            }
        }
    }
}