String fileName = "myfile.xml"; OutputStream out = new ByteArrayOutputStream(); 
try { 
    dbxClient.getFile("/" + fileName, null, out); 
} catch (DbxException e) { 
    e.printStackTrace(); 
} 

System.out.println("File Contente: " + out.toString());