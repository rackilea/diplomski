public class recursiveSierpinski {
   public static void draw(int n, double x0, double y0, double x1,
      double y1, double x2, double y2) {
      // if reach base case, method return
      if (n==0) return;
      // define array xm, ym to store x and y values of midpoints
      double [] xm = new double[3];
      double [] ym = new double[3];

      // assign midpoints’ values to xm and ym
      xm[0]= (x0+x1)/2;
      xm[1]= (x1+x2)/2;
      xm[2]= (x2+x0)/2;
      ym[0]= (y0+y1)/2;
      ym[1]= (y1+y2)/2;
      ym[2]= (y2+y0)/2;

      StdDraw.filledPolygon(xm, ym); //this makes triangle

      draw(n-1,xm[0],ym[0],xm[1],ym[1],x1,y1);
      draw(n-1,xm[1],ym[1],xm[2],ym[2],x2,y2);
      draw(n-1,xm[2],ym[2],xm[0],ym[0],x0,y0);


     }
     public static void main(String[] args) {
     // N levels of recursion
     int N = Integer.parseInt(args[0]);
     // outline the triangle

     double t = Math.sqrt(3.0) / 2.0;


     StdDraw.setPenColor(StdDraw.BLACK);
     // fill arrays initially to draw black solid TRIANGLE xm, ym = 0.0, 0.0, 0.5, t, 1.0, 0.0
     StdDraw.filledPolygon(xm, ym);

     StdDraw.setPenColor(StdDraw.WHITE);
     draw(N, 0.0, 0.0, 0.5, t, 1.0, 0.0);
     }
}