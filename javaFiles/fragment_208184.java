// assuming backup directory is with in current working directory
ftpClient.setFileType(FTP.BINARY_FILE_TYPE);//binary files
ftpClient.changeWorkingDirectory("backup");
//this overwrites the existing file
ftpClient.storeFile(fileName, is);
//if you don't want to overwrite it use storeUniqueFile