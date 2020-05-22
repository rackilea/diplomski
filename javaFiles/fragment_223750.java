Set<String> hashSet = new HashSet<String>(); // consist 90 elements
Set<Object> hashSet2 = new HashSet<Object>(); // consist 9 elements
for (String string : hashSet) {
    if (hashSet2.contains(string)) {
        System.out.println(string + "\t is present in tracking     sheet");
    } else {
        System.out.println(string + "\t is not sheet");
    }
}