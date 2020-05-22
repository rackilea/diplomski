public class Connection implements Runnable
{
    private static String temp_ip="127.0.0.1";
    //temp_ip="74.125.225.179";
    private Socket sock;
    private static final int Port=80;
    private static final String IP = temp_ip;
    public double lat;
    public double longi;
    public double accuracy;
    private String message;
    public Location location;
    private PrintWriter out;
    private boolean running=false;
    Thread thread=null;

public void start()
{
    if (thread ==null)
    {
        set_run(true);
        try {thread=new Thread(this);}
        catch (Exception e){e.printStackTrace();}
        try {thread.start();}
        catch (Exception e){e.printStackTrace();}
    }
}
public void run()
{
    try{
        init_ports();
        init_connect();
    }catch(Exception e){
        e.printStackTrace();
    }
}
public void set_run(boolean a)
{
    running=a;
}

private void synchronized init_connect() throws InterruptedException
{
    Log.v(null, "init_connect called");
    try
    {
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())),true);
        notifyAll();
    }
    catch (UnknownHostException e)
    {e.printStackTrace();}
    catch (IOException e)
    {e.printStackTrace();}
    catch (Exception e)
    {e.printStackTrace();}}
private void init_ports()
{
    Log.v(null, "init_ports called");
    try
    {
        InetAddress addr= InetAddress.getByName(IP);
        sock= new Socket(addr,Port);
    }
    catch (UnknownHostException e)
    {e.printStackTrace();}
    catch (IOException e)
    {e.printStackTrace();}
}
public void synchronized wardit() throws InterruptedException
{
    lat= location.getLatitude();
    longi= location.getLongitude();
    accuracy= location.getAccuracy();
    message= String.valueOf(lat)+"$"+String.valueOf(longi)+"$"+String.valueOf(accuracy);
    while(out==null){
        wait();
    }
    out.println(message);
    Log.v(null, "wardit called");
}