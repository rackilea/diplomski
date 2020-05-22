public static void main(String[]args){

    DateTime dt1 = new DateTime();    
    DateTime dt2 = new DateTime(dt1); // dt2 = dt1
    DateTime dt3 = new DateTime(dt1).minusSeconds(10); // dt3 < dt1
    DateTime dt4 = new DateTime(dt1).plusSeconds(10); // dt4 > dt1

    int result1 = dt1.compareTo(dt2);
    int result2 = dt1.compareTo(dt3);
    int result3 = dt1.compareTo(dt4);

    System.out.println("Results " + result1 + " , " + result2 + " , " + result3);

}