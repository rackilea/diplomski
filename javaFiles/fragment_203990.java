Set<String> a = Sets.newHashSet("A", "B");
Set<String> b = Sets.newHashSet("1", "2");
Set<String> c = Sets.newHashSet("#", "+");
Set<List<String>> powerSet = Sets.cartesianProduct(a, b, c); // variable-length argument list
for (List<String> subSet : powerSet)
    System.out.println(subSet);