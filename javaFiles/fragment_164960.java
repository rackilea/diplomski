String previous = "";
 for (Iterator<String> i = inputList.iterator(); i.hasNext();) {
    String current = i.next();
    if (current.equals(previous)) {
        i.remove(); // removes current item
    }
    previous = current;
 }