public static void main(String[] args) {
    Calendar calendar = Calendar.getInstance();
    calendar = new GregorianCalendar(2014, 07, 18);
    Date startDate = calendar.getTime();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yy");
    String formatted = simpleDateFormat.format(startDate);
    String result = "";
    String header2 = String.format("%s %20s %20s %20s%n", "Account", "Date", "Hours", "Skill");
    result += header2;
    result += "-----------------------------------------------------------------------\n";
    result += String.format("summary %20s%n", formatted);
    result += String.format("%-40s %4d%n", "Totabl Billable:", 40);
    result += String.format("%-40s %4d%n", "Total Non-Billable:", 0);
    result += String.format("%-40s %4d%n", "Total Hours:", 40);
    System.out.println(result);
}