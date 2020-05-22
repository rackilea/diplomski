ArrayList ls = null; // wrong
ArrayList<String> ls = null; // correct
ls = new ArrayList<String>(); // can do "new ArrayList<>();" if you're using Java 8

public static ArrayList getContent(File f) // wrong
public static ArrayList<String> getContent(File f) // correct