public void showLogoutMessage(){
FacesContext context = FacesContext.getCurrentInstance();
context.addMessage(null, new FacesMessage("Logout",
        "Sie werden abgemeldet!"));}

public void logout() {
try {
    Thread thread = new Thread();
    try {
        thread.sleep(3000);
        ExternalContext ec = FacesContext.getCurrentInstance()
                .getExternalContext();
        ec.invalidateSession();
        ec.redirect(ec.getRequestContextPath() + "/home.xhtml");
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
} catch (IOException e) {
    e.printStackTrace();}
}