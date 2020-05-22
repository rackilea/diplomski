private void getLoggedInUser(){
    WebContext ctx = WebContextFactory.get();
    HttpSession session=ctx.getSession();
    if(session.getAttribute("loggedIn")!=null && (Boolean)session.getAttribute("loggedIn")==true){
        if(session.getAttribute("user")!=null){
            try{
                return (Person)session.getAttribute("user");
            }catch (ClassCastException ex){
                return null;
            }
        }else{
            return null;
        }
    }else{
        return null;
    }
}