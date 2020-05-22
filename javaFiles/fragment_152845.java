import java.util.Random;

public class Program1 {
public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println("Random uppercase letters: ");
    for(int i = 1; i <= 40; i++ ) {
        System.out.print(randomLetter()+" "); 
        if(i % 10 == 0) 
            System.out.print("\n");
    }   
    System.out.println("\n");
    System.out.println("Random single digits: ");
    for(int i = 1; i <= 40; i++) {
        System.out.print(randomNumber()+ " ");
        if(i % 10 == 0) 
            System.out.print("\n"); 
    }
}

public static char randomLetter(){
    int letter = (int) (Math.random()*26) + (int) 'A';
    return (char)letter;
}
public static char randomNumber(){
    int number = (int)(Math.random()*10) + (int) '0';
    return (char)number;
}   
}