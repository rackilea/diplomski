for (Product p : list) {
    String data1 = p.field1;
    int data2 = p.field2;
    int data3 = p.field3;
    int data4 = p.field4;
    int data5 = p.field5;
    int data6 = p.field6;
    int data7 = p.field7;
    int data8 = p.field8;

    Object[] row = {data1, data2, data3, data4, data5, data6, data7, data8};
    model.addRow(row);

}