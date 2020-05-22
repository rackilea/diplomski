import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.ResultSegment;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.file.CloudFile;
import com.microsoft.azure.storage.file.CloudFileClient;
import com.microsoft.azure.storage.file.CloudFileDirectory;
import com.microsoft.azure.storage.file.CloudFileShare;
import com.microsoft.azure.storage.file.ListFileItem;

public class DownloadFilesFromFileShare {

    private static final String connectionString = "DefaultEndpointsProtocol=https;AccountName=<your account name>;AccountKey=<your account key>;EndpointSuffix=core.windows.net;";

    private static final String fileShareName = "<source file share>";
    private static final String localRootDirPath = "<local directory like D:/backup or /home/user/backup>";

    private static final String backupFileShareName = "<backup file share>";

    public static boolean isDir(CloudFileDirectory root, String itemName) throws URISyntaxException, StorageException {
        CloudFileDirectory dir = root.getDirectoryReference(itemName);
        boolean flag = true;
        try {
            dir.listFilesAndDirectoriesSegmented();
        } catch (StorageException e) {
            flag = false;
        }
        return flag;
    }

    public static void download(CloudFileDirectory root, CloudFileDirectory backup) throws StorageException, URISyntaxException, FileNotFoundException {
        System.out.println("=>\t"+root.getName());
        ResultSegment<ListFileItem> list = root.listFilesAndDirectoriesSegmented();
        for (ListFileItem item : list.getResults()) {
            URI uri = item.getUri();
            String path = uri.getPath();
            String localPath = localRootDirPath + path;
            String itemName = new File(path).getName();
            boolean flag = isDir(root, itemName);
            System.out.println(item.getUri() + "\t" + path +"\t"+itemName + "\t" + flag);
            if(flag) {
                // Create local directory
                new File(localPath).mkdirs();
                CloudFileDirectory next = root.getDirectoryReference(itemName);
                // Create cloud directory for backup
                CloudFileDirectory backupNext = backup.getDirectoryReference(itemName);
                backupNext.createIfNotExists();
                // Recursion
                download(next, backupNext);
            } else {
                // Download file to local
                FileOutputStream fos = new FileOutputStream(localPath);
                CloudFile file = root.getFileReference(itemName);
                file.download(fos);
                // Start Copy to cloud directory for backup without upload again
                CloudFile backupFile = backup.getFileReference(itemName);
                backupFile.startCopy(file);
                System.out.println("Downloaded " + path);
            }
        }
    }

    public static void main(String[] args) throws InvalidKeyException, URISyntaxException, StorageException, FileNotFoundException {
        CloudStorageAccount account = CloudStorageAccount.parse(connectionString);
        CloudFileClient fileClient = account.createCloudFileClient();
        CloudFileShare share = fileClient.getShareReference(fileShareName);
        CloudFileDirectory rootDir = share.getRootDirectoryReference();
        CloudFileShare backupShare = fileClient.getShareReference(backupFileShareName);
        backupShare.createIfNotExists();
        CloudFileDirectory backupRootDir = backupShare.getRootDirectoryReference();
        download(rootDir, backupRootDir);
    }

}