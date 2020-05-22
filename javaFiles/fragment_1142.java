public class KeywordRemoteLibrary extends AnnotationLibrary {

static List<String> includePatterns = new ArrayList<String>() {{
    add("keywords/*.class");
}};

public KeywordRemoteLibrary() {
    super(includePatterns);
}

public static void main(String[] args) {
    RemoteServer server = new RemoteServer("127.0.0.1", 8270);
    server.putLibrary("/RPC2", new KeywordRemoteLibrary());
    try {
        server.start();
    }
    catch(Exception e) {
        e.printStackTrace();
    }
}
}