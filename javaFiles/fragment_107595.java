Iterator<String[]> iter = stringArrayList.iterator();
while (iter.hasNext()) {
  String[] arr = iter.next();
  for (int i = 0; i < arr.length; i++) {
    System.out.println("string" + i + " = " + arr[i]);
  }
}