//String key = "A-B-C-D";       // => [A, B, C, D]
String key = "A-B-C-D-E-F"; // => [A_B, C, D, E, F]
int keep = 3;
String[] res = key.split("-");
if (res.length > 4) {
    String first = String.join("-", Arrays.asList(res).subList(0, keep)); 
    List<String> lst = new ArrayList<>();
    lst.add(first);
    lst.addAll(Arrays.asList(res).subList(keep, res.length));
    res = new String[lst.size()];
    res = lst.toArray(res);
}
System.out.println(Arrays.toString(res));