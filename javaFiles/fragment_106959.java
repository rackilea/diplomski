private Cloud cloud = new Cloud();

//...Probably within the init method...
Random rnd = new Random();
int cloudDensity = 10 + rnd.nextInt(990);
for (int index = 0; index < cloudDensity; index++) {

    int x = rnd.nextInt(getWidth());
    int y = rnd.nextInt(getHeight());
    cloud.add(new Point2D.Double(x, y));

}