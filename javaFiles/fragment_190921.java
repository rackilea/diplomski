package principal;

public class Principal
{
    public static void main(String[] args)
    {
        Thread filosofos[]=new Thread[5];

        for (int i=0;i<5;i++) {
            filosofos[i]=new Thread(new Filosofo());
            filosofos[i].start();
        }
    }
}