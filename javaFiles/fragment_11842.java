DefaultArray arr = new DefaultArray(5, 0);
for(int i = 0; i < 5; i++) {
    arr.set(i, i);
}
for(int i = 0; i < 10; i++) {
    System.out.println(arr.get(i) * 10);
}