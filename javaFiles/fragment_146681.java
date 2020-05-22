import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.storage.Storage;
import com.google.api.services.storage.StorageScopes;
import com.google.api.services.storage.model.Objects;
import com.google.api.services.storage.model.StorageObject;
import com.google.common.collect.Lists;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.LinkedList;
import java.util.List;


class GCSFileStorage {
    String bucket = "bucket_name";
    String remoteDirectoryPath = "remote/path";
    Storage storage

    public GCSFileStorage() throws GeneralSecurityException, IOException {
        storage = setupStorage();
    }

    List<String> list() throws IOException {
        List<String> allItems = new LinkedList<String>();
        Objects response = storage.objects().list(bucket).
            setPrefix(remoteDirectoryPath).execute();
        for (StorageObject obj: response.getItems()) {
            allItems.add(obj.getName());
        }
        while (response.getNextPageToken() != null) {
            String pageToken = response.getNextPageToken();
            response = storage.objects().list(bucket).
                setPrefix(remoteDirectoryPath).setPageToken(pageToken).execute();
            for (StorageObject obj: response.getItems()) {
                allItems.add(obj.getName());
            }
        }
        return allItems;
    }


    Storage setupStorage() throws GeneralSecurityException, IOException {
        GoogleCredential credential = new GoogleCredential.Builder().
            setTransport(new NetHttpTransport()).
            setJsonFactory(new JacksonFactory()).
            setServiceAccountId("your_account_id").
            setServiceAccountScopes(
                Lists.newArrayList(StorageScopes.DEVSTORAGE_FULL_CONTROL)).
            setServiceAccountPrivateKeyFromP12File(
                new File("/local/path/to/private/key.p12")).
            build();

        return new Storage.
            Builder(new NetHttpTransport(),
                new JacksonFactory(), credential).
            setApplicationName("foo").build();
    }
}