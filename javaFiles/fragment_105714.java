import com.microsoft.aad.adal4j.AuthenticationContext;
import com.microsoft.aad.adal4j.AuthenticationResult;
import com.microsoft.aad.adal4j.ClientCredential; // for service principal

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Account specific values
String tenantId = <your tenant id>
String clientId = <your client id>
String password = <your password>

// use adal to Authenticate
AuthenticationContext authContext = null;
AuthenticationResult authResult = null;
ExecutorService service = null;

try {
    service = Executors.newFixedThreadPool(1);
    String url = "https://login.microsoftonline.com/" + tenantId + "/oauth2/authorize";
    authContext = new AuthenticationContext(url,
                                            false,
                                            service);
        ClientCredential clientCred = new ClientCredential(clientId, password);
        Future<AuthenticationResult>  future = authContext.acquireToken(
                                                        "https://management.azure.com/",
                                                        clientCred,
                                                        null);
    authResult = future.get();
} catch (Exception ex) {
    // handle exception as needed
} finally {
    service.shutdown();
}