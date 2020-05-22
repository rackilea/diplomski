import java.util.Random;
    import java.lang.Math;

    public class Thesis4 {

public static void main (String [] args){

    int totalRTIncorrect = 0;
    int totalRTCorrect = 0;
    int totalCorrect = 0;
    int totalIncorrect = 0;

    for (int j = 0; j < 10000;j++){
        int correct = 0;
        int incorrect = 0;
        int incorrect2 = 0;
        int incorrect3 =0;
        int rtCorrect = 0;
        int rtIncorrect = 0;
        int time = 0;

        while(correct<88 && incorrect<88){
            Random rand = new Random();
            int pickedNumber = rand.nextInt(400);

            if (pickedNumber<108){
                correct++;
                //incorrect--;
                //incorrect2--;
                //incorrect3--;
                time++;

            }
            else if (pickedNumber>107 && pickedNumber<208){
                incorrect++;
                //  correct--;
                //  incorrect2--;
                //  incorrect3--;
                time++;
            }
            else if (pickedNumber>207&&pickedNumber<309){
                incorrect2++;
                //  correct--;
                //  incorrect--;
                //  incorrect3--;
                time++;
            }
            else if (pickedNumber>308){
                incorrect3++;
                //  correct--;
                //  incorrect--;
                //  incorrect2--;
                time++;
            }
        }
        if (correct == 88){
            rtCorrect = time;
            totalCorrect++;
        }
        else if (incorrect == 88){
            rtIncorrect = time;
            totalIncorrect++;
        }
        else if (incorrect2 == 88){
            rtIncorrect = time;
            totalIncorrect++;
        }
        else if (incorrect3 == 88){
            rtIncorrect=time;
            totalIncorrect++;
        }

        totalRTIncorrect = totalRTIncorrect + rtIncorrect;
        totalRTCorrect = totalRTCorrect + rtCorrect;
    }
    System.out.printf ("Total Correct Responses: %d \nTotal Incorrect Responses: %d", totalCorrect, totalIncorrect);
    System.out.printf ("\nTotal Correct RT's: %d \nTotal Incorrect RT's: %d\n", totalRTCorrect, totalRTIncorrect);

    //computation of the standard deviation of the three variables
    double meanValue=(totalCorrect+totalRTCorrect+totalRTIncorrect)/3.0; //step1

    double a= (totalCorrect-meanValue)*(totalCorrect-meanValue);         //step2
    double b= (totalRTCorrect-meanValue)*(totalRTCorrect-meanValue);
    double c= (totalRTIncorrect-meanValue)*(totalRTIncorrect-meanValue);

    double mean2=(a+b+c)/3.0;                                          //step3

    double standard_deviation=Math.sqrt(mean2);                        //step4
    System.out.printf ("\nThe standard deviation of the three variables is %f\n",standard_deviation);

}
 }