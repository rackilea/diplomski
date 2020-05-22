Object[] myArray = jArray.toArray();
myArray = Arrays.sort(myArray);
JSONArray sortedJArray = new JSONArray();
for (Object obj : myArray) {
  sortedJArray.add(obj);
}