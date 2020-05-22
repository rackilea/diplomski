Date d=jXDatePicker1.getDate();
    System.out.println(d);
    DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
    String date=df.format(d);
    System.out.println(date);

PreparedStatement statement = connect
      .prepareStatement("INSERT INTO BILLING (DATE) VALUES('"+date+"')");