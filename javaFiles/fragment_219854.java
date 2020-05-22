String header = "";
int nFiles = 0;

RandomAccessFile raFile = new RandomAccessFile( "filename", "r" );

byte[] buffer = new byte[3];
int numRead = raFile.read( buffer ); 
header = new String( buffer, StandardCharsets.US_ASCII.name() );

int numSkipped = raFile.skipBytes(1);

nFiles = raFile.read(); // The byte is read as an integer between 0 and 255