public class TestServer  extends NanoHTTPD {

public static boolean isTesting=false;
public TestServer() {
    super(8080);
}
@Override public Response serve(IHTTPSession session) {
    Method method = session.getMethod();
    Map<String,String> params = session.getParms();
    String uri = session.getUri();
    if (uri.length()>1){
        //remove the starting /
        uri=uri.substring(1).toLowerCase();
    } else{
        uri="";
    }

    System.out.println("method: ["+method + "] uri: [" + uri +"]");
    String msg = "";
    Map<String, String> parms = session.getParms();
    if ("".equals(uri)){
        //TextFiles.loadString just loads the whole file in a single string.
        msg=TextFiles.loadString("C:/server/index.html");
        return new NanoHTTPD.Response(msg);
    }else//handle log refreshing
    if ("log".equals(uri)){
        System.out.println("Log requested ...");
        while(!Logging.webLogQueue.isEmpty()){
            msg+="<p>"+Logging.webLogQueue.poll()+"</p>";
        }
        return new NanoHTTPD.Response(msg);
    }else if ("suites".equals(uri)){
        System.out.println("suites requested ...");

        // fill msg with suites  ...

        return new NanoHTTPD.Response(msg);
    } else if (("status".equals(uri))){
        System.out.println("status requested ...");
        msg=(isTesting?"Testing...":"Idle");
        return new NanoHTTPD.Response(msg);
    }else{
        for(String paramKey:parms.keySet()){
            String[] value=params.get(paramKey).split(" ");
            Logging.log("<p>"+Logging.getTimeStamp()+" Parameter: "+paramKey+"="+    params.get(paramKey)+"</p>");
            if ("tcl".equalsIgnoreCase(paramKey)){
                Logging.log("run started : "+params.get(paramKey));
                while(isTesting){
                    try {
                        Logging.log("test pending : "+params.get(paramKey));
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Logging.log("test starting: "+params.get(paramKey));
                //Raise a flag while executing a test run
                isTesting=true;
                try {
                    Logging.log("Attempting to execute: "+params.get(paramKey));
                    BananaTest.execute(value);
                    Logging.log("Ttest finished: "+params.get(paramKey));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                isTesting=false;
            }
        }
    }
    msg=TextFiles.loadString("C:/server/index.html");
    return new NanoHTTPD.Response(msg);
}


public static void main(String[] args) {
    ServerRunner.run(TestServer.class);
}