// Also use generic types properly!
ListIterator<String> lItr = al.listIterator();
while(lItr.hasNext()) {
    String s = lItr.next();
    System.out.println(s);
    if(s.equals("A")) {
        lItr.set("a");
        lItr.add("C"); // note the change here
    }
    else if(s.equals("B")) {
        lItr.set("b");
    }
}