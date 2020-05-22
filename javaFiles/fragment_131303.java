public static void main(String[] args) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX");
    Date date = new Date();
    String dateString = dateFormat.format(date); // You need to use "dateString" for your JSON
    System.out.println(dateString); // Output
}