String act = request.getParameter("act");
if (act == null) {
    //no button has been selected
} else if (act.equals("delete")) {
    //delete button was pressed
} else if (act.equals("update")) {
    //update button was pressed
} else {
    //someone has altered the HTML and sent a different value!
}