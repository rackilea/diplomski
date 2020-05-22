import java.util.ArrayList;
import java.util.Random;


public class Main {

int static maximum(ArrayList A){
    int max=0;
    for(int s=0; s<A.size(); s++){
        if(A.get(s)>max){
            max=A.get(s);
        }
    }
    return max;
}


public static void main(String[] args) {

    ArrayList<Integer> player1 = new ArrayList<Integer>();
    ArrayList<Integer> player2 = new ArrayList<Integer>();


    Random rn = new Random();

    for (int i=0; i<=5; i++){
    int value1 = rn.nextInt(13)+1;
    player1.add(value1);
    } 
    System.out.println(player1);

    for (int i=0; i<=5; i++){
    int value2 = rn.nextInt(13)+1;
    player2.add(value2);
    }
    System.out.println(player2);
    int max1=maximum(player1);
    int max2=maximum(player2);

    if(max1>max2){
        System.out.println("player1 is winner");

    } else if (max1<max2){
        System.out.println("player2 is winner");
    } else {
    System.out.println("tie");
                    }

                    }
     }