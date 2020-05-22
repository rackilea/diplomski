import net.spy.memcached.MemcachedClient;
public class memfunc implements java.io.Serializable{
    Connection conn;
    private int urlid;
    private String er;
    private static MemcachedClient c = null;
static {
      try {
c = new MemcachedClient(new InetSocketAddress("127.0.0.1",11211));
} catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }
   }
public float[][] avgInfo(){
        String key=host;
        host=hostParser(host);
        String[] info=new String[6];
        if(c.get(key)==null && key==host){
                 ---------your code----
Future<Boolean> set= c.set(key, 3600, info);
             }
    return (String[]) c.get(key);}