String[] array1 = {"A", "B", "C"};
String[] array2 = {"A", "B"};
String[] array3 = {"A"};
Set<String> s1 = new HashSet<>(Arrays.asList(array1));
Set<String> s2 = new HashSet<>(Arrays.asList(array2));
Set<String> s3 = new HashSet<>(Arrays.asList(array3));

// now take the intersection of s1 and s2, followed by s1 and s3
s1.retainAll(s2);
s1.retainAll(s3);

for (String item : s1) {
    System.out.println("common item: " + item);
}