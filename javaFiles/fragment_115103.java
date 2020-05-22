public static void main(String... args) {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.MONTH, -1);
    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));

    System.out.println(cal.get(Calendar.MONTH));
    System.out.println(cal.get(Calendar.DAY_OF_MONTH));
}