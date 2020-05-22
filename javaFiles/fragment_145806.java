String foundplayer = "";
Thread t=new Thread()
{
public void run()
{
  foundplayer = db.getUsername();
}
};
t.start();
t.join();