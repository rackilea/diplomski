public static void main(String[] args) {
    long frames = 0;
    joglplat m = new joglplat();
    while(true){
        frames++;
        // other code here
        System.out.println("framerate: " + ((System.nanoTime() / 1000000  - startTime) / frames ) );
    }
}