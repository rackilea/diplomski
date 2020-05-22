Collection<String> listDir = new ArrayList(Arrays.asList("1","2", "3", "4", "5", "6", "7"));
Collection<String> listDirCopy = new ArrayList<>();
listDirCopy.addAll(listDir);
Collection<String> listDB = new ArrayList(Arrays.asList("1","3", "5", "7", "9"));
List<String> destinationList = new ArrayList<String>(); 

listDir.removeAll(listDB);
listDB.removeAll(listDirCopy);

destinationList.addAll(listDir);
destinationList.addAll(listDB);
System.out.println(destinationList);