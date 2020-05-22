import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import com.microsoft.windowsazure.Configuration;
import com.microsoft.windowsazure.core.utils.KeyStoreType;
import com.microsoft.windowsazure.management.configuration.ManagementConfiguration;
import com.microsoft.windowsazure.management.compute.ComputeManagementService;
import com.microsoft.windowsazure.management.compute.ComputeManagementClient;
import com.microsoft.windowsazure.management.network.NetworkManagementService;
import com.microsoft.windowsazure.management.network.NetworkManagementClient;

String uri = "https://management.core.windows.net/";
        String subscriptionId = "<your subscription id>";
        String keyStoreLocation = "<KeyStore.jks>";
        String keyStorePassword = "<password for KeyStore>";

        Configuration config = ManagementConfiguration.configure(
                new URI(uri),
                subscriptionId,
                keyStoreLocation, // the file path to the JKS
                keyStorePassword, // the password for the JKS
                KeyStoreType.jks // flags that I'm using a JKS keystore
              );

// For Compute Management
ComputeManagementClient computeManagementClient = ComputeManagementService.create(config);

//For Networing Management
NetworkManagementClient client = NetworkManagementService.create(config);

// Others like above