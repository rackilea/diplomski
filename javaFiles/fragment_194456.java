conn = ConnectDB.ConDB();
        if(conn==null){
            conn = ConnectDB.ConDB();
            System.out.print("connection close... openning ");
        }
        try{

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();`enter code here`

            jTable_incomingChk.setModel(DbUtils.resultSetToTableModel(rs));