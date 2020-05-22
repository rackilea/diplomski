public class Configuration {

    private int LOGO = 0;


    public Configuration(Context cont){

        String myResourceId = cont.getResources().getString(R.string.app_LOGO);
        String[] resourceParts = myResourceId.split("\\.");
        String packName = cont.getPackageName();
        int logo = cont.getResources().getIdentifier(resourceParts[2],               resourceParts[1], packName);

        setLogo(logo);
    }
    /**
     * @return the logo
     */
    public int getLogo() {
        return LOGO;
    }
    /**
     * set the Logo
     */
    public void setLogo(int logo) {
        LOGO = logo;
    }
}