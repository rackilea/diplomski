// Get file from file name
File file = new File("U:\intranet_root\intranet\R1112B2.zip");

// Get length of file in bytes
long fileSizeInBytes = file.length();
// Convert the bytes to Kilobytes (1 KB = 1024 Bytes)
long fileSizeInKB = fileSizeInBytes / 1024;
// Convert the KB to MegaBytes (1 MB = 1024 KBytes)
long fileSizeInMB = fileSizeInKB / 1024;

if (fileSizeInMB > 27) {
  ...
}