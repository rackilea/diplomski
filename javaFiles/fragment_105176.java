public static void main(String[] args) {

    String date = "1.43701862E9";
    java.util.Date time = new java.util.Date(Double.valueOf(date).longValue()*1000);

    System.out.println(time);
}