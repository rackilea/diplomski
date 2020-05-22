public class MyServlet {

    static final Dictionary stuff = new Hashtable();

    static {
        // load at startup
        reloadDictionary();
    }

    // call this whenever you want to reload the files
    static void reloadDictionary() {
        // reload files
    }

    // ...
}