public String[][] yourMethod(){
String[][] array = new String[0][0];
    Vector v = getVectorFromSC(Order order);

    for(int i=0;i<v.size();i++)
    {
       String[][] tempArray = getTable2C(Order order, v.get(i));

       array = concat(array,tempArray);

    }
    return allArray;
}

public String[][] concat(String[][] a, String[][] b) {
                String[][] result = new String[a.length + b.length][];
                System.arraycopy(a, 0, result, 0, a.length);
                System.arraycopy(b, 0, result, a.length, b.length);
                return result;
}