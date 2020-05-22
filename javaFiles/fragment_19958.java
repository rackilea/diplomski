List<FilterByList> myList = Collections.singletonList(
new FilterByList("superman", "antman", "ACTION", 123, "batman"));

System.out.println(myList);
if (myList.stream().map(FilterByList::getActionHero3).allMatch("batman"::equals)) {
    System.out.println("found it!");
} else {
    System.out.println("************************* Did not find anything!!1");
}