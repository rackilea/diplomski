import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;

import com.google.cloud.ReadChannel;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

/**
 * An example which reads the contents of the specified object/blob from GCS
 * and prints the contents to STDOUT.
 *
 * Run it as PROGRAM_NAME <BUCKET_NAME> <BLOB_PATH>
 */
public class ReadObjectSample {
  private static final int BUFFER_SIZE = 64 * 1024;

  public static void main(String[] args) throws IOException {
    // Instantiates a Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name for the GCS bucket
    String bucketName = args[0];
    // The path of the blob (i.e. GCS object) within the GCS bucket.
    String blobPath = args[1];

    printBlob(storage, bucketName, blobPath);
  }

  // Reads from the specified blob present in the GCS bucket and prints the contents to STDOUT.
  private static void printBlob(Storage storage, String bucketName, String blobPath) throws IOException {
    try (ReadChannel reader = storage.reader(bucketName, blobPath)) {
      WritableByteChannel outChannel = Channels.newChannel(System.out);
      ByteBuffer bytes = ByteBuffer.allocate(BUFFER_SIZE);
      while (reader.read(bytes) > 0) {
        bytes.flip();
        outChannel.write(bytes);
        bytes.clear();
      }
    }
  }
}