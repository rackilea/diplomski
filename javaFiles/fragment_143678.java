import java.util.*;
import java.lang.*;

class Site {
    private String url;

    public Site(String url) {
        this.url = url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}

class A {
    public static Map<String, Site> sites;

    static {
        sites = new HashMap<>();
        sites.put("site1", new Site("http://url1.com"));
        sites.put("site2", new Site("http://url2.com"));
    }

}

class B {

    public void setUrl(String alias, String value) {
        if(A.sites.containsKey(alias)) {
            A.sites.get(alias).setUrl(value);
        }
    }

}

class Application {  
    public static void main(String args[]) {
        B b = new B();
        b.setUrl("site1", "a1");
        b.setUrl("site2", "a2");
        b.setUrl("site3", "a3");

        System.out.println(A.sites.get("site1").getUrl());
        System.out.println(A.sites.get("site2").getUrl());
    }
}