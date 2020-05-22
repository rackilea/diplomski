String[] monthOrder = { "January", "Febuary", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December" };
Set<String> sqlMonths = new HashSet<String>();
// Write your code to load the sqlMonths.
sqlMonths.add("March");
sqlMonths.add("December");
sqlMonths.add("Febuary");
List<String> sortedMonths = new ArrayList<String>();

for (String month : monthOrder) {
  if (sqlMonths.contains(month))
    sortedMonths.add(month);
}
System.out.println(sortedMonths);