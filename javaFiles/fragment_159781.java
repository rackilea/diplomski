public class MySingleton extends Mongo{
    private static MySingleton instance = null;

    protected MySingleton () 
          throws UnknownHostException,UnsupportedOperationException{


    }

    protected MySingleton (String ip, int port) 
               throws UnknownHostException,UnsupportedOperationException{
        super(ip, port);
    }

    public static synchronized MySingleton getInstance(String ip, int port) 
                     throws UnknownHostException{

        if (instance == null){
          instance =  new MySingleton(ip,port);
        }

         return instance;
    }
}