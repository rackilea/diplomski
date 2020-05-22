List<List<String>> lists=Arrays.asList(
        Arrays.asList("I1", "I2", "I5"),
        Arrays.asList("I1", "I2", "I3"),
        Arrays.asList("I1", "I2", "I5"),
        Arrays.asList("I1", "I2", "I3"),
        Arrays.asList("I1", "I5", "I2"),
        Arrays.asList("I1", "I3", "I2")
);
List<List<String>> filtered=new ArrayList<>();
List<List<String>> duplicates=new ArrayList<>();
HashSet<List<String>> filter=new HashSet<>();
for(List<String> list: lists){
  if(!filter.contains(list)){
    filter.add(list);
    filtered.add(list);
  } else {
    duplicates.add(list);
  }
}
System.out.println("Original: "+lists);
System.out.println("Filtered: "+filtered);
System.out.println("Duplicates: "+duplicates);
System.out.println("(Filter: "+filter+")");