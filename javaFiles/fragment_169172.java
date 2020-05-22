String selectsql = "select current_day ,  open_val , high_val , low_val ,close_val  from   historical_data where symbol_name = ?";
    List<Data> myList = new ArrayList(Data); 
    while(Rset.next())
                {
                    String current_day =  SgxRset.getString("current_day");
                    String open_val =  SgxRset.getString("open_val");
                    String high_val =  SgxRset.getString("high_val");
                    String low_val =  SgxRset.getString("low_val");
                    String close_val =  SgxRset.getString("close_val");

                    Data data = new Data(current_day,open_val,high_val,low_val,close_val);
                    myList.add(data);
                }