while (rs.next()){
    for (int i=1;i<=numOfCols;i++)
        tuple[i-1]=rs.getString(i);
    result.addElement(tuple);
    isResultEmpty=0;
}