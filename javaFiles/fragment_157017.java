import java.util.Scanner;

public class Stopky {

    private volatile static int check = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Stlačte 0 pre začatie stopiek."); // "Press 0 for start
        int start = sc.nextInt();
        if (start == 0) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (check != 0 && sc.hasNextInt())
                        check = sc.nextInt();
                }
            }).start();
            for (int hodiny = 0; hodiny < 24; hodiny++) //hours
            {
                for (int minuty = 0; minuty < 60; minuty++) //minutes
                {
                    for (int sekundy = 0; sekundy < 60; sekundy++) //seconds
                    {
                        for (int ms = 0; ms < 1000; ms++) //miliseconds
                            try {
                                Thread.sleep(1);
                            } catch (Exception e) {
                            }
                        {
                            if (check == 0)
                                break;
                            System.out.println(hodiny + ":" + minuty + ":" + sekundy);
                        }
                        if (check == 0)
                            break;
                    }
                    if (check == 0)
                        break;
                }
                if (check == 0)
                    break;
            }
        }
        sc.close();
    }
}