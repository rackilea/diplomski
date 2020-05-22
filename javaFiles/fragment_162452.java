pointcut firstPointcut (String s, String t) : call (public void helloWorld(String, String)) && args (s, t);

void around (String s, String t) : firstPointcut (s, t) {
    System.out.println("1st passed value: " + s);
    System.out.println("2nd passed value: " + t);
    s = "changed first one"; 
    t = "changed second one";
    proceed (s, t);
}