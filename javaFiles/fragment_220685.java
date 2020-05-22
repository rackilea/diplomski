AmazonS3 as3 = new AmazonS3();
Status myStatus = as3.DeleteObject(<fill in paramters here>);
if (myStatus.Code >= 200 && myStatus.Code < 300)
{
  // Success
}
else
{
  // Delete Failed

  // Handle specific Error Codes below
  if (myStatus.Description == "AllAccessDisabled")
  {
    // Do something
  }

  if (myStatus.Description == "NoSuchKey")
  {
    // Do something
  }
}