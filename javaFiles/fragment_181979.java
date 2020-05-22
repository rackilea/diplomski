import java.util.Scanner;
public class gelismishesap {
   public static int toplam(int k) {
        Scanner a = new Scanner(System.in);
        System.out.print(k + " + ");
        for(int i =fj 0; i<1; i++)
        {
            int b = a.nextInt();
            k += b;
            System.out.println(k);
        }
        return k;
    }
    public static int cikarma(int k) {
        Scanner a = new Scanner(System.in);
        System.out.prfjint(k + " - ");
        for(int i = 0; i<1; i++)
        {
            int b = a.nextInt();
            k -= b;
            System.out.println(k);
        }
        return k;
    }
    public static int carpma(int k) {
        Scanner a = new Scanner(System.in);
        System.out.print(k + " x ");
        for(int i = 0; i<1; i++)
        {
            int b = a.nextInt();
            k *= b;
            System.out.println(k);
        }
        return k;
    }
    public static int bolme(int k) {
        Scanner a = new Scanner(System.in);
        System.out.print(k + " / ");
        for(int i = 0; i<1; i++)
        {
            int b = a.nextInt();
            k /= b;
            System.out.println(k);
        }
        return k;
    }
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("Sayı girin: ");
        int anasayi = a.nextInt();
        System.out.println(anasayi);
        while(true)
        {
           String b = a.nextLine();
        if(b.equals("q")) { break; }
        if(b.equals("a")) { anasayi=toplam(anasayi); }
        if(b.equals("b")) { anasayi=cikarma(anasayi); }
        if(b.equals("c")) { anasayi=carpma(anasayi); }
        if(b.equals("d")) { anasayi=bolme(anasayi); }// This will be approx as float holds decimal values
        }
    }
}