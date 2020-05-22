ArrayList<ArrayList<Date>> parentList = new ArrayList<ArrayList<Date>>();
ArrayList<Date> childList = new ArrayList<Date>();

//Adding a date to childList
childList.add(date1);

//Adding a 'row' to parentList
parentList.add(new ArrayList<Date>(childList)); // COPY!

//Adding another date to childList
childList.add(date2);

//Adding another row to parentList
parentList.add(new ArrayList<Date>(childList)); // COPY!

System.out.println(parentList.get(0));
System.out.println(parentList.get(1));