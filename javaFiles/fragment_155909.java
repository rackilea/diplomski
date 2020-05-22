public static void main(String[] args) {


    List<String> list = new LinkedList<String>();

    for(int i = 5; i > 0; i-- ){
        wrapWithNumber(list, i);
    }


    for (String string : editListToBeInTriangleShape(list)) {
        System.out.println(string);
    };
}

/**
      * Wrap the number strings in the llist with a perticular number.
 * @param list list of Strings
 * @param ba number which need to wrapp the list with.
 */
private void wrapWithNumber(List<String> list, final int ba) {

    list.add(0, String.format("%d",ba));

    for (int i = 1; i < list.size(); i++) {
        String newformat = "%1$d " + list.get(i) + " %1$d";
        list.remove(list.get(i));
        list.add(i,String.format(newformat, ba));
    }

    String lastFormat = "%1$d";
    for(int i = 0; i < 2 * list.size();i++){
        lastFormat += " %1$d";
    }

    if(list.size() != 1) {
        list.add(String.format(lastFormat, ba));
    }
}

/**
 * Arrage the Strings in the list in triangular manner.
 * @param list list of Strings.
 */
private List<String> editListToBeInTriangleShape(final List<String> list) {

    final List<String> returnList = new LinkedList<String>();

    for (int i = list.size(); i > 0; i--) {
        String s = list.get(list.size()-i);
        int possition = list.size()*2 + s.length()/2;
        returnList.add(String.format("%"+possition+"s", s));
    }

    return returnList;
}