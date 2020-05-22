InputStream binaryFile = rs_ivol.getBinaryStream("BLOB_COLUMN_FROM_BY_DB");
FileOutputStream outputFile = new FileOutputStream(myoutpath);  
int aux = 0;
byte[] buffer = new byte[1024];
while ((aux = binaryFile.read(buffer)) > 0)
{
    outputFile.write(buffer, 0, aux);
}