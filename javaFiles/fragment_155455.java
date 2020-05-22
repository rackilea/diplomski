ResultSetMetaData rsmd = resSet.getMetaData();
int colCount = rsmd.getColumnCount();

String rValue = "";
for (int i = 1; i <= colCount ; i++){

    String name = rsmd.getColumnName(i);
    rValue += name + " ";
}

System.out.println(rValue);