public enum DBType {
    //ser properties you want for db. url, username are just dummy values
    HSQLDB("url", "username", "password"), MYSQL("url", "username", "password");
    private String url;
    private String username;
    private String password;
    private DBType(String url, String username, String password){
        this.url = url;
        //set other properties
    }
    public String getUrl(){
        return this.url;
    }
    //getter for all the other values

}