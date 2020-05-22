String SQL = "select * from Table_name where col_1 IN (";
    For int I = 0; I  < list.size; I++ {
      SQL+=list[I];
      If(I != list.size -1){
        SQL+=","; 
      }else{
        SQL +=")";
      }
    }
    List <Class_Name> systemtails = jdbcTemplateObject.query(SQL, new 
    Class_Name_Mapper());