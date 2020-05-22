import com.amazonaws.services.s3.*;
import com.amazonaws.services.s3.model.*;

...
AmazonS3 client = new AmazonS3Client();
S3Object xFile = client.getObject("mybucket", "x.db");
InputStream contents = xFile.getObjectContent();