public static void main(String[] args) {

    Object obj;
    { 
        Stopwatch w = new Stopwatch();
        obj = w;
    }
    System.out.println(obj);
    System.out.println(w);
}