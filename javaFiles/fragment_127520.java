public static int[] readfiles(String file)
{

try {
    File f = new File(file);
    Scanner scan = new Scanner(f);
    List<Integer> arr = new ArrayList<>();
    int crr = 0;

    while(scan.hasNextInt()) 
    {
        arr.add(scan.nextInt());
        System.out.println(arr.get(crr++));
    }

    System.out.println("Jarvis Algorithm Test\n");

    System.out.println(ctr);
    scan.useDelimiter(",|\\s*");

    /** Make an object of Jarvis class **/
    int n = ctr;
    for (int i = 0; i < n; i++) {

        System.out.println(n);
        Point[] points = new Point[n];

        System.out.println("Reading X,Y Values From File");

        points[i] = new Point();
        points[i].x = arr.get(i);
        points[i].y = arr.get(i + 1);

        i++;
        System.out.println("(x,y) values are:" + points[i].x + "\t" + points[i].y);
    }