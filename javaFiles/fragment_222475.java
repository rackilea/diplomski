// Properties for archive file we're creating
Map<String, String> archiveProperties = new HashMap<>(); 
archiveProperties.put("create", "true");
archiveProperties.put("encoding", "UTF-8");        

String filePathName = System.getProperty("user.dir") + FILE_SEPARATOR + ".." + FILE_SEPARATOR + "myfile.zip";
filePathName = filePathName.replace('\\','/');
filePathName = filePathName.replaceAll(" ", "%20");
URI archiveLocation = URI.create("jar:file:///" + filePathName);

// Create archive
FileSystem archive = FileSystems.newFileSystem(archiveLocation, archiveProperties);