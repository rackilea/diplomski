Iterator<Object> i1= tree.iterator();
while (i1.hasNext()) {
    element1 = i1.next();

    Iterator<Object> i2 = tree.tailSet(element1,true).iterator();
    while (i2.hasNext()) {
        element2  = i2.next();
        System.out.println("Interact: " + element1 + " " + element2  );
    }

}