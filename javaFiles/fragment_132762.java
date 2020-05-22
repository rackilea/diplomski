public static void main(String[] args)
{
    int delay = 2000; // delay for 2 seconds
    int period = 500; // repeat every .5 seconds

    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new SayHello(), delay, period);
}