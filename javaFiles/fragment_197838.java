import java.util.Scanner;
public class q7 {

public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    //String[] artist = {"Tahsan"};

    //declaring an array that contains 18 elements in total, which includes the name of the artist and 17 tracks
    String[] songs = {"Tahsan", "Alo","Irsha", "Odrissho Robi","Prematal", "Aalo", "Nei", "Rodela Dupur","Ke Tumi",
            "Alo","Brittalpona","durotto","Brishtite","Durey","Bhalobashar Maane","Tomay Ghire","Kothopokhoton", "Prottaborton"
            };
    int testCase = keyboard.nextInt();
    switch(testCase){
        case 1: System.out.println(songs[16]);
               break;
        case 2: System.out.println(songs[songs.length-1]);
               break;
        default :   for (String i : songs)
                        System.out.println(i);
    }
  }
}