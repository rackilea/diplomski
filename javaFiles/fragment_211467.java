import java.io.IOException;

import com.sun.jna.LastErrorException;
import com.sun.jna.Native;

public class FileUtils {

  private static final int EACCES = 13;
  private static final int EEXIST = 17;
  private static final int EMLINK = 31;
  private static final int EROFS = 30;
  private static final int ENOSPC = 28;
  private static final int ENAMETOOLONG = 63;

  static void mkdir(String path) throws IOException {

    try {
      NativeLinkFileUtils.mkdir(path);

    } catch (LastErrorException e) {
      int errno = e.getErrorCode();
      if (errno == EACCES)
        throw new IOException(
            "Write permission is denied for the parent directory in which the new directory is to be added.");
      if (errno == EEXIST)
        throw new IOException("A file named " + path + " already exists.");
      if (errno == EMLINK)
        throw new IOException(
            "The parent directory has too many links (entries).  Well-designed file systems never report this error, because they permit more links than your disk could possibly hold. However, you must still take account of the possibility of this error, as it could result from network access to a file system on another machine.");
      if (errno == ENOSPC)
        throw new IOException(
            "The file system doesn't have enough room to create the new directory.");
      if (errno == EROFS)
        throw new IOException(
            "The parent directory of the directory being created is on a read-only file system and cannot be modified.");
      if (errno == EACCES)
        throw new IOException(
            "The process does not have search permission for a directory component of the file name.");
      if (errno == ENAMETOOLONG)
        throw new IOException(
            "This error is used when either the total length of a file name is greater than PATH_MAX, or when an individual file name component has a length greater than NAME_MAX. See section 31.6 Limits on File System Capacity.");
      else
        throw new IOException("unknown error:" + errno);
    }




  }
}

class NativeLinkFileUtils {
  static {
    try {
      Native.register("c");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static native int mkdir(String dir) throws LastErrorException;

}