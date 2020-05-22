TriangleMath tMath = new TriangleMath();
// where TriangleMath is the name of the other class, and "tMath" is
// an instance of it. then:

Scanner keyboard = new Scanner(System.in);
int point1 = (int) keyboard.nextLine().charAt(0);
int point2 = (int) keyboard.nextLine().charAt(0);
int point3 = (int) keyboard.nextLine().charAt(0);
int area = tMath.area(point1, point2, point3);