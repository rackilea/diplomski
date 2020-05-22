List<Object[]> list = query.getResultList();
for (int index = 0; index < list.size(); index++) {
    Object[] objArr = list.get(index); //this will return a row of your result into objArr
    for (int j = 0; j < 3; j++) {
        //here, you are now iterating through the columns in each row. Since your select query has 3 columns j <3 in the for loop
        System.out.println(objArr[j].toString());
    }
}