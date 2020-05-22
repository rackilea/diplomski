class Runner extends Thread
{
boolean stop = false;
public void run()
{
   while (!stop)
   {
       doSomething();
   }
}
public void exit()
{
    stop = true;
}
}