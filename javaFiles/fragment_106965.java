Iterator<String> iter = a.iterator();
while (iter.hasNext()) {
    String str = iter.next();
    a = new ArrayList<>();
    System.out.println(str);
}