public static void main(String args[]) {

    double t0,h,n=1,b;
    double t;


    Scanner sc = new Scanner(System.in);
    System.out.println("Initial time : ");
    t0=sc.nextDouble();
    System.out.println("Variation : ");
    h=sc.nextDouble();
    System.out.println("Nomber of terms : ");
    b=sc.nextDouble();
    ArrayList<Double> tblT = new ArrayList<Double>();
    while(b!=n-1) {

      t=(t0+(n-1)*h);
      n++;

      tblT.add(t);

      System.out.print(t+" ");

    }
    //tblT will now contain the elements. You can use tblT.get(index) to access the elements

}