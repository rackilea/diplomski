@Service
public class CredentialsService {

    private VaultTemplate vaultTemplate;

    /**
     * To Secure Credentials
     *
     * @param credentials
     * @return VaultResponse
     * @throws URISyntaxException
     */
    public void secureCredentials(Credentials credentials) throws URISyntaxException {
        //vaultTemplate.write("credentials/myapp", credentials);
        initVaultTemplate();
        vaultTemplate.write("kv/myapp", credentials);
    }


    public void secureCredentials(String storagePlace, Credentials credentials) {
        initVaultTemplate();
        vaultTemplate.write("kv/" + storagePlace, credentials);
    }


    /**
     * To Retrieve Credentials
     *
     * @return Credentials
     * @throws URISyntaxException
     */
    public Credentials accessCredentials() throws URISyntaxException {
        //VaultResponseSupport<Credentials> response = vaultTemplate.read("credentials/myapp", Credentials.class);
        initVaultTemplate();
        VaultResponseSupport<Credentials> response = vaultTemplate.read("kv/myapp", Credentials.class);
        return response.getData();
        // TODO special case when there are no values
    }

    /**
     * @param nameOfsecrets key name
     * @return if is presented or empty object
     */
    public Credentials accessCredentials(String nameOfsecrets) {
        initVaultTemplate();
        VaultResponseSupport<Credentials> response = vaultTemplate.read("kv/" + nameOfsecrets, Credentials.class);
        if (response != null) {
            return response.getData();
        } else {
            return new Credentials();
        }
    }

    public boolean deleteCredentials(String name) {
        initVaultTemplate();
        vaultTemplate.delete("kv/" + name);
        return true;
    }
}

private void initVaultTemplate() {
            VaultEndpoint endpoint = new VaultEndpoint();
            endpoint.setHost("localhost");
            endpoint.setPort(8200);
            endpoint.setScheme("http");

            vaultTemplate = new VaultTemplate(endpoint, new VaultConfig().clientAuthentication());
        }