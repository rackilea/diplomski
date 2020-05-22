@Component
@Configuration
@ConfigurationProperties("application")
public class TeradataConfiguration {

    @NotNull
    private String usernameTeradata;

    @NotNull
    private String passwordTeradata;

    @NotNull
    private String servernameTeradata;

    @NotNull
    private String charsetTeradata;

    @NotNull
    private String tmodeTeradata;

    @NotNull
    private String dsnameTeradata;

    @NotNull
    private String portTeradata;

    public void setUsernameTeradata(String usernameTeradata) {
        this.usernameTeradata = usernameTeradata;
    }


    public void setPasswordTeradata(String passwordTeradata) {
        this.passwordTeradata = passwordTeradata;
    }


    public void setServernameTeradata(String servernameTeradata) {
        this.servernameTeradata = servernameTeradata;
    }


    public void setCharsetTeradata(String charsetTeradata) {
        this.charsetTeradata = charsetTeradata;
    }


    public void setTmodeTeradata(String tmodeTeradata) {
        this.tmodeTeradata = tmodeTeradata;
    }


    public void setDsnameTeradata(String dsnameTeradata) {
        this.dsnameTeradata = dsnameTeradata;
    }


    public void setPortTeradata(String portTeradata) {
        this.portTeradata = portTeradata;
    }

    @Bean
    DataSource teraDataSource() throws SQLException {

        TeraDataSource teraDataSource = new TeraDataSource();
        //This is username
        teraDataSource.setuser(usernameTeradata);
        //This is password
        teraDataSource.setpassword(passwordTeradata);
        //Charset which could be UTF-8 or something else
        teraDataSource.setCharSet(charsetTeradata);
        //Tmode which could be ANSII or something else
        teraDataSource.setTMODE(tmodeTeradata);
        //This is your server name
        teraDataSource.setDSName(servernameTeradata);
        //This is teradata port which by default is 1025
        teraDataSource.setDbsPort(portTeradata);
        //This is your data base name
        teraDataSource.setDatabaseName(dsnameTeradata);
        return teraDataSource;

    }
}