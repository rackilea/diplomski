import java.util.*;
        public class TeamScore {

        public static boolean createWinner(int points1, int points2)  
         {
          if (points1 > points2)
          {
          return true;
          }
                else
         {
          return false;  
         } 

         return false;
         }
        public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] team1Array = new int[4];
        int[] team2Array = new int[4];

        int team1Score = 0;
        int team2Score = 0;


        for (int i =0; i<4; i++) {
     System.out.println("Enter Team 1 points: ");
             team1Array[i]= Integer.parseInt(in.nextLine());
    System.out.println("Enter Team 2 points: ");
             team2Array[i] = Integer.parseInt(in.nextLine());
        }




         for (int i=0; i <4; i++)

         {

        if (createWinner(team1Array[i],team2Array[1])) {
           team1Score+=1;
       } else {
           team2Score+=1;
       }

         }


  if(team1Score>0 && team2Score == 0){
        System.out.println("Team 1 has perfect record !");
    }else{
          System.out.println("Win "+ team1Score);

          System.out.println("Loss "+ team2Score);

        }





        }
}