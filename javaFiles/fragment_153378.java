private Random random = new Random();

public void GetRandomValues(){
    // get width of JPanel
    int w = getWidth();

    // get height of JPanel
    int h = getHeight();

    x1 = random.nextInt(w);
    x2 = random.nextInt(w);
    y1 = random.nextInt(h);
    x2 = random.nextInt(h);
}