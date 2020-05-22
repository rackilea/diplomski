/*  if */while(rs.next()) {
       int j = 0;
        String add1 = rs.getString("value");
        t1.setEditable(false);

   // String str9; //= new String(); redundant
        String str9 = "B" + add1; //B is the default value add1 is the value from database  
        String str10 = str9;
        String query = "select MC from final";
        ResultSet rs1 = st.executeQuery(query);
        while (rs1.next()) {   
            if (str10.equals(rs1.getString("MC")) {
                j++; //j = j + 1;
               // j=new Integer(j+1); you simply increment j twice
                str10 = str9 + j;// EDITED LINE!
            }
            t1.setText(str10);  
        }  
    }