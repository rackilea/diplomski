public class ConfigureCustomer {

    public static void main(String[] args){
        String customer = args[0];
        String versionName = args[1];
        System.out.println(String.format("Configuring customer %s with versionName %s", customer, versionName ));
    }
}