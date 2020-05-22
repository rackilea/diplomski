Ftp ftp = new Ftp(hostname,username,pass);
ftp.connect();

// get directory listing

Enumeration listing = ftp.getDirListing();

// enumerate thru listing

while(listing.hasMoreElements()) {

FtpFile file = (FtpFile)listing.nextElement();

// check to see if filename matches 
System.out.println("Filename: " + file.getFilename());

}