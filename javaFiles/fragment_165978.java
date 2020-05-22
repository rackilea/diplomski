public static myMethod() {    
    try {
        int a=0,b=0;
        a=b/0;      
    } catch (Exception e) {
        callException(e);
    }    
}

public static void callException(Exception e) {
    System.out.println(e);
}