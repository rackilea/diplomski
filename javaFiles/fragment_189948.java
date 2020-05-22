List<String> duplicateList = (List<String>) Arrays.asList("Android" , "Android", "iOS" ,"Windows mobile");

HashSet<String> listToSet = new HashSet<String>(duplicateList);

List<String> listWithoutDuplicates = new ArrayList<String>(listToSet);

System.out.println(listWithoutDuplicates);