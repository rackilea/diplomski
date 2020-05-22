public class Date {
    private int d;
    private int m;
    private int y;    

public static Date createNewDate(int d, int m, int y) throws IllegalArgumentException {
     // your checks here

     return new Date(int d, int m, int y);
}

private Date(int d, int m, int y) {
    this.d = d;
    this.m = m;
    this.y = y; //etc
  }
}