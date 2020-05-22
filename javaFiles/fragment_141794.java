//example to validate if user is logged
HttpSession session = request.getSession();
User loggedUser = (User)session.getAttribute("user"); //it returns Object
if (loggedUser == null) {
    //there's no user logged in!
    //do something about it!
}
//the user is logged, he/she can continue working...