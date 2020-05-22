public class ZZZ {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(1024,1024);
        StdDraw.setXscale(-15,15);
        StdDraw.setYscale(-15,15);

        double x=0.0;
        double y=0.0;
        double r=5.0;

        StdDraw.setPenRadius(0.01);
        StdDraw.circle(x, y, r);

        int j=StdRandom.uniform(2);
        for(int s=1;s<10;s++){
            x=x+r;
            r=r/3*2;
            StdDraw.circle(x, y, r);
        }

        x = 0.0;
        r = 5.0;
        int k=StdRandom.uniform(2);
        for(int i=1;i<10;i++){
            x=x-r;
            r=r/3*2;
            StdDraw.circle(x, y, r);
        }
    }
}