public class Outer extends Thread
    ...
}

class Data implements Serializable {
     String a = "ok baby";
     String b = "hi there";
     Outer outer;
}