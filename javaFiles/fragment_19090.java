List<String> foos = new ArrayList<String>();

for (int i = 1; i < Integer.MAX_VALUE; i++) {
    String foo = request.getParameter("foo" + i);
    if (foo == null) break;
    foos.add(foo);
}

// ...