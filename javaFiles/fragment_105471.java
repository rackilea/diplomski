ListIterator<String> i1 = players.listIterator(0);
while (i1.hasNext()) {
    String p1 = i1.next();
    ListIterator<String> i2 = players.listIterator(i1.nextIndex());
    while (i2.hasNext()) {
        String p2 = i2.next();
        System.out.println("Interact: " + p1 + ", " + p2);
    }
}