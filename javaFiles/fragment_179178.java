@ManagedBean(name="agreement")
@ViewScoped //removed RequestScoped, this WILL make the difference
public class AgreementBean {
    private boolean generate = false; 
    public void generateLicenseFile(){
        generate = !generate;
    }
    //getter and setter for generate field
}