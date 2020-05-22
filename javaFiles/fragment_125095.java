@ModelAttribute
public void load(ModelMap model, @AuthenticationPrincipal CustomUser user){

 if(user != null){
    long userId = user.getId();
    //Query database with userId and add data to model
 }

}