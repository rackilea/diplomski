public static void main(String[] args)
{
    ArrayList<Integer> test = new ArrayList<>();
    ConsoleProgressBar bar = new ConsoleProgressBar(10, 50);

    bar.start();

    for (int i = 0; i <= 10; i++)
    {
        int sum = i + 5;

        test.add(sum);

        bar.refreshProgressBar();
        System.out.format( "%s", bar.getCurrent() );
        bar.step();
        bar.sleep( 1000 );
    }

    bar.stop();
}