@Override
public void run()
{
    while(running)
    {
        update();
        render()
        System.out.println("X-Koordinate " + Var.ballX + " " + "Y-Koordinate " + Var.ballY);
        Thread.sleep(1000L/60L);
    }
}