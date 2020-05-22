while (s.hasNext()) {
    s.useDelimiter("(,.*)|[^0-9]+");
    String next = s.next();
    if (next.length() > 0)
        array.add(next);
    System.out.println(array);
}