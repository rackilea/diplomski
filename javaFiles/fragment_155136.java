if (arguments[i] instanceof String){
    //set the strings into the varchar2 fields
    preparedStmt.setString(i+1, arguments[i].toString());
}
else if (arguments[i] instanceof Integer){
        System.out.println("Integer " + i);
        //set the integers into the integer fields
    preparedStmt.setInt(i+1, Integer.parseInt(arguments[i].toString()));
}