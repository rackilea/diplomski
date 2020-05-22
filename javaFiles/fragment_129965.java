private static boolean arrayEquals(String[] array1, String[] array2) {
List<String> list1 = Arrays.asList(array1);
List<String> list2 = Arrays.asList(array2);

Collections.sort (list1);
Collections.sort (list2);
return list1.equals(list2);
}