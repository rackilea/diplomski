comboBox = new JComboBox();
 //should be before this block
 try {
        while(con.rs.next())
        {
        //  System.out.println("True");
        //here you are using comboBox. so it should be initialized before this statement.
            comboBox.addItem(con.rs.getString(1));
        }
    } catch (Exception e2) {
        // TODO Auto-generated catch block
        e2.printStackTrace();
    }//not after this block