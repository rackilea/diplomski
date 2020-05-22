@Test
public void excel() {
    Calendar cl = Calendar.getInstance();
    cl.set(Calendar.YEAR, 1900);
    cl.set(Calendar.MONTH, Calendar.JANUARY);
    cl.set(Calendar.DAY_OF_MONTH, 0);
    cl.add(Calendar.DAY_OF_MONTH, 42321 - 1);
    System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(cl.getTime()));

    double excel = 2.31481481481481E-005;
    cl.set(Calendar.SECOND, (int) Math.round(excel * 86400));
    cl.set(Calendar.MINUTE, (int) Math.round(excel * 86400 / 60));
    cl.set(Calendar.HOUR_OF_DAY, (int) Math.round(excel * 86400 / 60 / 60));
    System.out.println(new SimpleDateFormat("HH:mm:ss").format(cl.getTime()));
}