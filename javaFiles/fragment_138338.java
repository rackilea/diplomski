public static void main(String[] args) throws Exception {
    Calendar c = Calendar.getInstance();
    c.set(Calendar.MONTH, Calendar.OCTOBER);
    c.set(Calendar.DAY_OF_MONTH, 31);
    c.add(Calendar.MONTH, 1);
    System.out.println(c.getTime());
}