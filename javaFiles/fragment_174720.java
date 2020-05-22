public static void main(String[] args) {
  Calendar yy =Calendar.getInstance();
  Calendar xx= Calendar.getInstance();
  xx.set(2001, 10,10);
  Data dt = new Data(yy);
  Data xt = new Data(xx);
  System.out.println(dt.whichIsEarlier(xt));
}