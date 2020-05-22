public static void main(String[] args) {
    King newLoan = new King();
    Date theDate = new java.util.Date();
    Circle newCircle = new Circle();
    String s = new String();

    ArrayList<Object> list = new ArrayList<Object>();

    list.add(newLoan);

    list.add(theDate);

    list.add(newCircle);

    list.add(s);

    System.out.println(newLoan.toString(list));
}

public String toString(ArrayList<Object> list) {
    String results = "";
    for (Object d : list) {
        results += "," + d.toString();
    }
    return results;
}