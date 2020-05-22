public class elips extends GOval{
    static int x, y, w, h;
    int cd;
    public boolean canRemove = false;
    Random rand = new Random();

    long timeStart;

    public elips(){
        super(x, y, w, h);
        canRemove = false;
        cd = rand.nextInt(100);
        x = rand.nextInt(780) + 20;
        y = rand.nextInt(580) + 20;
        w = rand.nextInt(80) + 20;
        h = rand.nextInt(80) + 20;

        timeStart = System.currentTimeMillis();
    }

    public void cdRemove(){
        if(System.currentTimeMillis() > timeStart + cd)
            this.canRemove = true;
    }
}