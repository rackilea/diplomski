List<String> list = new ArrayList<String>(Arrays.asList("Periodic", "Multiple", "Single", "Subsequent", "Consecutive"));
int indexOfSubName = 0;
int indexOfMultipleName = 0;
for (int i = 0; i < list.size(); i++) {
    String name = list.get(i);
    if (name.equalsIgnoreCase("Subsequent")) {
        indexOfSubName = list.indexOf(name);
    }
    if (name.equalsIgnoreCase("Multiple")) {
        indexOfMultipleName = list.indexOf(name);
    }
}
int min = Math.min(indexOfMultipleName, indexOfSubName);
int max = Math.max(indexOfMultipleName, indexOfSubName);
Collections.rotate(list.subList(min, max+1), 1);
System.out.println(list);