Integer[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

List<Integer> view = Arrays.asList(a).subList(3, 6);

for (int i = 0; i < view.size(); i++)
    view.set(i, view.get(i) * 10);

System.out.println(view);
System.out.println(Arrays.toString(a));