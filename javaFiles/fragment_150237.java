function getData(Param tableName, Param column1, Param column2){
        String sql = "SELECT "+column1+"','"+column2+"' 
                FROM `" + tableName + "` WHERE "+column1+" = "+column2;
        }

//overloaded
       function getData(Param tableName, Param column1, Param column2,Param column3){
        String sql = "SELECT "+column1+"','"+column2+"','"column3+"' 
                FROM `" + tableName + "` WHERE "+column1+" = "+column2;
        }