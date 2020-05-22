// or elsewhere of course...
public static void main(String... args) {
  TransferManager manager = new TransferManager(credentials);
  FileXfer upld = new FileXfer(manager);
  upld.fileUpload....
}

public class FileXfer {
  private final TransferManager tx;
  ...

  public FileXfer(TransferManager tx) {
    //ensure that tx is not null.
    if(tx == null) { throw new NullPointerException("tx"); }
    this.tx = tx;
  }

  ...
  public void FileUpload(...) {
    ...
    upload=tx.upload(request);
    ...
  }
}