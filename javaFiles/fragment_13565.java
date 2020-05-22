import java.io.*;
import org.apache.commons.io.*;
import org.apache.commons.vfs2.*;
import org.apache.commons.vfs2.impl.*;
import org.apache.commons.vfs2.provider.sftp.*;

public class CopyRemoteFile {
    public static void copyRemoteFiles(final String host, final String user, final String remotePath, final String localPath)
            throws IOException {
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
            File newFile = new File(localPath + "/" + file.getName().getBaseName());
            if (file.getType() == FileType.FILE && newFile.lastModified() != file.getContent().getLastModifiedTime()) {
                FileUtils.copyInputStreamToFile(file.getContent().getInputStream(), newFile);
                newFile.setLastModified(file.getContent().getLastModifiedTime());
            } 
            file.close();
        }

        fo.close();

        fsManager.close();
    }
}