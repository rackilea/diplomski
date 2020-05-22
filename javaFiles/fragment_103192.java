class factorial{
  public static void main(String[] args){
    int num = 0;
    try {
         num = Integer.parseInt(args[0]);
    }
    catch(Exception e){
        System.out.println(e+" Cannot convert arg to int, exiting..");
    }
    System.out.println(num );

  }
}