ListIterator<String> listIterator = al.listIterator();
String element;
String prev = "";

while (listIterator.hasNext()) {
    element = listIterator.next();
    if (element.contains("c") && prev.contains("b")) {
        System.out.println("VALID");
        break;
    }
    prev = element;
}