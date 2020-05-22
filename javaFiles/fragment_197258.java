public static void main(String args[]) {
    long time = 1387670712 * (long) 1000;
    Date past = new Date(time);
    Date now = new Date();

    long i1 = TimeUnit.MILLISECONDS.toDays(now.getTime() - past.getTime());
    long i2 = TimeUnit.MILLISECONDS.toMinutes(now.getTime() - past.getTime());
    long i3 = TimeUnit.MILLISECONDS.toHours(now.getTime() - past.getTime());
    String day = i1+" days ago";
    String sec = i2+" minutes ago";
    String hours = i3 +" hours ago";
    long[] values = new long[] {i1,i2,i3};
    Arrays.sort(values);
    for(int i = 0 ;i<values.length;i++){
        if(values[i] != 0){
            String postfix = values[i] == i1 ? day : (values[i] == i2 ?  sec : hours);
            System.out.println("minimum = " + postfix );
            System.exit(0);
        }
    }
    System.out.println("no values or all 0");
}