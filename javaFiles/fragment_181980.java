import java.util.Scanner;

public class gelismishesap{
int anasayi; // instance variable
public void toplam() {

    Scanner a = new Scanner(System.in);
    System.out.print(this.anasayi + " + ");
    for(int i = 0; i<1; i++)
    {
        int b = a.nextInt();
        this.anasayi += b;
        System.out.println(this.anasayi);
    }
}
public void cikarma() {
    Scanner a = new Scanner(System.in);
    System.out.print(this.anasayi + " - ");
    for(int i = 0; i<1; i++)
    {
        int b = a.nextInt();
        this.anasayi -= b;
        System.out.println(this.anasayi);
    }
}
public void carpma() {
    Scanner a = new Scanner(System.in);
    System.out.print(this.anasayi + " x ");
    for(int i = 0; i<1; i++)
    {
        int b = a.nextInt();
        this.anasayi *= b;
        System.out.println(this.anasayi);
    }
}
public void bolme() {
    Scanner a = new Scanner(System.in);
    System.out.print(this.anasayi + " / ");
    for(int i = 0; i<1; i++)
    {
        int b = a.nextInt();
        this.anasayi /= b;
        System.out.println(this.anasayi);
    }
}
public static void main(String[] args) {
    Scanner a = new Scanner(System.in);
    System.out.print("Sayı girin: ");
    gelismishesap ref = new gelismishesap(); // you will need an object(instance) to manipulate instance variables
    ref.anasayi = a.nextInt();
    System.out.println(ref.anasayi);
    while(true)
    {
       String b = a.nextLine();
    if(b.equals("q")) { break; }
    if(b.equals("a")) { ref.toplam(); }
    if(b.equals("b")) { ref.cikarma(); }
    if(b.equals("c")) { ref.carpma(); }
    if(b.equals("d")) { ref.bolme(); }
    }
}}