Iterator<Integer> it = arr.iterator();
while(it.hasNext()) {
    int element = it.next();
    System.out.println(element);
    it.remove();
}