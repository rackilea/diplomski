public void setEvenList(String listString) {
    List<Integer> evenNumbers = new ArrayList<Integer>();
    for (int i = getLowerLimit(); i <= getUpperLimit(); ++i) {
        if (i%2 == 0) {
            evenNumbers.add(i);
        }
    }
    listString = evenNumbers.toString();
    listString = listString.substring(1, (listString.length())-1);
    System.out.println(listString);
    this.evenList = listString;
}
public String getEvenList() {
    return evenList;
}