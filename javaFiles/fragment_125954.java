package aad.keyvault;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.naming.ServiceUnavailableException;
import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.io.IOUtils;

import com.microsoft.aad.adal4j.AuthenticationContext;
import com.microsoft.aad.adal4j.AuthenticationResult;
import com.microsoft.aad.adal4j.ClientCredential;

public class RestAPISample {

    private static final String subscriptionId = "<subscription_id>";
    private static final String resourceGroupName = "<resource_group_name>";
    private static final String vaultName = "<vault_name>";
    private static final String apiVersion = "2015-06-01";
    private static final String getKeyVaultInfoUri = String.format(
            "https://management.azure.com/subscriptions/%s/resourceGroups/%s/providers/Microsoft.KeyVault/vaults/%s?api-version=%s",
            subscriptionId, resourceGroupName, vaultName, apiVersion);

    private static final String tenantId = "<tenant_id>";
    private static final String authority = String.format("https://login.windows.net/%s", tenantId);
    private static final String clientId = "<client_id>";
    private static final String clientSecret = "<client_secret_key>";
    private static final String keyName = "<keyvault_key>";
    private static final String getInfoFromAKeyUri = String.format("https://%s.vault.azure.net/keys/%s?api-version=%s",
            vaultName, keyName, apiVersion);

    public static String getAccessToken(String resource)
            throws MalformedURLException, InterruptedException, ExecutionException, ServiceUnavailableException {
        AuthenticationContext context = null;
        AuthenticationResult result = null;
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(1);
            context = new AuthenticationContext(authority, true, service);
            ClientCredential credential = new ClientCredential(clientId, clientSecret);
            Future<AuthenticationResult> future = context.acquireToken(resource, credential, null);
            result = future.get();
        } finally {
            service.shutdown();
        }
        String accessToken = null;
        if (result == null) {
            throw new ServiceUnavailableException("authentication result was null");
        } else {
            accessToken = result.getAccessToken();
            System.out.println("Access Token: " + accessToken);
        }
        return accessToken;
    }

    public static void getKeyVaultInfo() throws MalformedURLException, IOException, ServiceUnavailableException,
            InterruptedException, ExecutionException {
        System.out.println(getKeyVaultInfoUri);
        HttpsURLConnection conn = (HttpsURLConnection) new URL(getKeyVaultInfoUri).openConnection();
        conn.setRequestProperty("Authorization", "Bearer " + getAccessToken("https://management.core.windows.net/"));
        conn.addRequestProperty("Content-Type", "application/json");
        String resp = IOUtils.toString(conn.getInputStream());
        System.out.println(resp);
    }

    public static void getKeyInfo() throws MalformedURLException, IOException, ServiceUnavailableException, InterruptedException, ExecutionException {
        System.out.println(getInfoFromAKeyUri);
        HttpsURLConnection conn = (HttpsURLConnection) new URL(getInfoFromAKeyUri).openConnection();
        conn.setRequestProperty("Authorization", "Bearer " + getAccessToken("https://vault.azure.net"));
        conn.addRequestProperty("Content-Type", "application/json");
        String resp = IOUtils.toString(conn.getInputStream());
        System.out.println(resp);
    }

    public static void main(String[] args)
            throws InterruptedException, ExecutionException, ServiceUnavailableException, IOException {
        getKeyVaultInfo();
        getKeyInfo();
    }

}