Iterator itr = list.iterator();
String strElement = "";
while (itr.hasNext()) {
    strElement = (String) itr.next();
    if (strElement.equals("2")) {
        itr.remove();
    }
}