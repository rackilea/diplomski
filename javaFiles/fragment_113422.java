import org.apache.commons.net.io.Util;
import org.apache.commons.net.io.CopyStreamListener;

private void copy(FileObject sourceFile, FileObject destinationFile, CopyStreamListener progressMonitor) throws IOException {
    InputStream sourceFileIn = sourceFile.getContent().getInputStream();
    try {
        OutputStream destinationFileOut = destinationFile.getContent().getOutputStream();
        try {
            Util.copyStream(sourceFileIn, destinationFileOut, Util.DEFAULT_COPY_BUFFER_SIZE, sourceFile.getContent().getSize(), progressMonitor);
        } finally {
            destinationFileOut.close();
        }
    } finally {
        sourceFileIn.close();
    }
}