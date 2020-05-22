public static void main(String[] args) {
       long testStartTime = System.nanoTime();;
       trimTest();
       long trimTestTime = System.nanoTime() - testStartTime;
       testStartTime = System.nanoTime();     
       replaceTest();
       long replaceTime = System.nanoTime() - testStartTime;           
       System.out.println("Time for trim(): " + trimTestTime);
       System.out.println("Time for replace(): " + replaceTime);            
}

public static void trimTest() {
    for(int i = 0; i < 1000000; i ++) {     
        new String("  string   ").trim();
    }
}
public static void replaceTest() {
    for(int i = 0; i < 1000000; i ++) {     
        new String("  string   ").replace(" ", "");
    }
}