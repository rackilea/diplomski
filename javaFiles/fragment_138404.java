String fileName = "K1.html";
String content = "K1 html file content here";
FileOutputStream outputStream = null;
try {
outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
outputStream.write(content.getBytes());
outputStream.close();
} catch (Exception e) {
e.printStackTrace();}

String path=getApplicationContext().getFilesDir().getAbsolutePath()+"/K1.html";
File file = new File ( path ); 
if ( file.exists() ) 
{
 // Toast File is exists
}
else
{
 // Toast File is not exists
}