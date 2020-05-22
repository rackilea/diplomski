List<Object> t = (List)m; // (2) compiles with warnings
t.add(1235); // it's a List<Object>, so we can add an Integer

for (String s : m) { // m only contains Strings, right?!
    System.out.println(s.length());
}