byte[] buffer = new byte[8192]; // Or whatever
int bytesRead;
while ((bytesRead = cis.read(buffer)) != -1)
{
    fos.write(buffer, 0, bytesRead);
}
fos.flush(); // Not strictly necessary, but can avoid close() masking issues