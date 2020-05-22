public class Site {
    String url;
    String id;
    String host;

    boolean contains(String str) {
        if(url.contains(str) || id.contains(str)) return true;
        return false;
    }
}