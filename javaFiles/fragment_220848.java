HashSet<String> compareSet = new HashSet<String> ();
...
groupInteger.empty ();
for (int i = 0; i < 5; i++) {
  groupInteger += arr[i] + " ";
}
System.out.println(groupInteger);
if (compareSet.contains(groupInteger)) {
    System.out.println("duplicate found ");
} else {
    compareSet.add(groupInteger);
}