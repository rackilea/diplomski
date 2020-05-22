DriveFile df = ...;
// sync version
DriveContentsResult rslt = df.open(mGAC, DriveFile.MODE_READ_ONLY, null).await();
if ((rslt != null) && rslt.getStatus().isSuccess()) {
  DriveContents cont = rslt.getDriveContents();
  InputStream is = cont.getInputStream();
  cont.discard(mGAC);    // or cont.commit();  they are equiv if READONLY
}
// async version
df.open(mGAC, DriveFile.MODE_READ_ONLY, null).setResultCallback(
  new ResultCallback<DriveContentsResult>() {
  @Override
  public void onResult(DriveContentsResult rslt) {
    if ((rslt != null) && rslt.getStatus().isSuccess()) {
      DriveContents cont = rslt.getDriveContents();
      InputStream is = cont.getInputStream();
      cont.discard(mGAC);    // or cont.commit();  they are equiv if READONLY
    }
  }
});