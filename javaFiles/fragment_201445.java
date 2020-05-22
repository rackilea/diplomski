for (int i = 0; i < 5; i++) {
    System.out.println(items);
    items.add(new Item());
}
System.out.println(items);
Collections.swap(items, 0, 4);
System.out.println(items);
Collections.swap(items, 2, 3);
System.out.println(items);
Collections.swap(items, 0, 2);
System.out.println(items);