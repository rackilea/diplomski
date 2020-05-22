//also assuming you will set the results in a Data class (yes, this can be replaced)
List<Data> dataList = new ArrayList<Data>();
while (rs.next()) {
    //logic to retrieve data...
    Data data = new Data();
    data.setSomething(rs.get(1));
    //more and more code to fill the data...

    //because it looks that you need it as String (wonder why you return a String as well)
    dataList.add(data);
}
//in this case, there's no validation in order to know if there's any result
//the validation must be in the client of this class and method checking if
//the result list is empty using if(!List#isEmpty) { some logic... }
return dataList;