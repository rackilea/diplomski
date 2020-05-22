List<MyObjects> myList = createObjects();


Map<String, Optional<String>> myMappedList = myList.stream()
             .collect(Collectors.groupingBy(MyObjects::getName, 
                     Collectors.mapping(MyObjects::getidSet, 
                         Collectors.maxBy((a, b) -> a.toString().length() - b.toString().length()))));

//Here's the output with your example (Using toString override in MyObjects Class):

System.out.println(myMappedList);

{CH2OH=Optional[223,256,295], CH2CH2OH=Optional[255,310]}