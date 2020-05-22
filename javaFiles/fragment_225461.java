input = connection.getInputStream();
byte[] buffer = new byte[4096];
int n;

OutputStream output = new FileOutputStream( file );
while ((n = input.read(buffer)) != -1) 
{
    output.write(buffer, 0, n);
}
output.close();