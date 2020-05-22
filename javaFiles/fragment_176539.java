InputStream stream = someClient.downloadApi(fileId);

// This reads the entire stream to the end of stream.
byte[] bytes = IOUtils.toByteArray(stream);

String mimeType = CommonUtils.fileTypeFromByteArray(bytes);
String fileExtension = 
        FormatToExtensionMapping.getByFormat(mimeType).getExtension();
String filePath = configuration.getDownloadFolder() + "/" ;
String fileName = UUID.randomUUID() + fileExtension;    
File file = new File(filePath+fileName);    
file.createNewFile();    

// Now you attempt to read more data from the stream.
FileUtils.copyInputStreamToFile(stream,file);    

int length = (int)file.length();