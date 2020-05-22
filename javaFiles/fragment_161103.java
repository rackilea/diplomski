HashSet<Integer> distinctIds = new HashSet<Integer>();

    MyRowData rowdata;
    int rowID;

    while((rowdata = this.getRowData())!=null ) // or however you iterate over the rows using reader etc
    {
    rowID = rowdata.getRowID(); 

    if(!distinctIds.contains(new Integer(rowID)))
    {
      distinctIds.add(rowID);
      inertDataInMysql(rowdata); //however you insert your data here
      System.out.println("Adding " + rowID);
    }
    }