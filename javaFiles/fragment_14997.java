String [] oldVal = {"one","two","three","Four"};
 String [] newVal = {"one","Two","Three","four"};

 Set <String> set1 = new TreeSet <String> (String.CASE_INSENSITIVE_ORDER);
 Set <String> set2 = new TreeSet <String> (String.CASE_INSENSITIVE_ORDER);

 set1.addAll(Arrays.asList(oldVal));
 set2.addAll(Arrays.asList(newVal));

 System.out.println("--Using Tree Set --- "+ set1.containsAll(set2));  // Return True