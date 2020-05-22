import java.math.*;

public class Position
{
    static double waist=66,neck=30,height=150;

    public static void main(String[]args)
    {
        double fat = 495 / ( 1.0324
            - (0.19077 * (Math.log(waist - neck)/Math.log(10)))
            + (0.15456) * (Math.log(height)/Math.log(10))
            ) - 450;

        System.out.println(fat);
    }
}