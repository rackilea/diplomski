public static void main(String[] args) {
    // TODO code application logic here

    Calendar c = Calendar.getInstance();
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    c.setTime(d);
    System.out.println(sdf.format(c.getTime()));


    c.setTime(d);
    c.add(Calendar.DATE, 10);
    System.out.println(sdf.format(c.getTime()));

}