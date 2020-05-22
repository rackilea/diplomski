import com.sun.tools.internal.ws.WsImport;

public class Main {

    static {
        System.getProperties().put("line.separator", "\n"); \\ or "\r\n"
    }

    public static void main(String[] args) throws Throwable {
        WsImport.main("service.wsdl -Xnocompile".split("\\s+"));
    }

}