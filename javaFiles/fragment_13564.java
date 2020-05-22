import java.io.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.vfs2.*;

public class CopyRemoteFile {
    public static void copyRemoteFiles(String host, String user, String remotePath, String localPath) throws IOException {
        FileSystemOptions fsOptions = new FileSystemOptions();
        SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(fsOptions, "no");
        SftpFileSystemConfigBuilder.getInstance().setIdentities(fsOptions,
                new File[] { new File(FileUtils.getUserDirectoryPath() + "/.ssh/id_dsa") });
        DefaultFileSystemManager fsManager = (DefaultFileSystemManager) VFS.getManager();
        String uri = "sftp://" + user + "@" + host + "/" + remotePath;

        FileObject fo = fsManager.resolveFile(uri, fsOptions);

        FileObject[] files = fo.getChildren();
        for (FileObject file : files) {
                    // We will be dealing with the files here only
            if (file.getType() == FileType.FILE) {
                FileUtils.copyInputStreamToFile(file.getContent().getInputStream(),
                        new File(localPath + "/" + file.getName().getBaseName()));
            }
            file.close();
        }

        fo.close();

        fsManager.close();
    }
}