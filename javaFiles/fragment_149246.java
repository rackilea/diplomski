if(insertToDB(Bean n)) {

   response.redirect("success.jsp?msg=hi");
} else {
    response.redirect("faliure.jsp?msg=bye");
}

public boolean insertTODB(Bean n){

//DB insertion logic return true false on success failure accordingly



}