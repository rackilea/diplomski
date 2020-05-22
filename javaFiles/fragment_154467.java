while (rs1.next) {
    YourClass obj = new YourClass();
    obj.setSomeProperty(rs.getString(1));
    obj.setAnotherProperty(rs.getString(2));
    // etc..
    cominbedDataSet.add(obj);
}