// assume that you have the UploadedFile object named uploadedFile
InputStreamReader reader = new InputStreamReader(uploadedFile.getInputStream());
int partition = 1024;
int length = 0;
int position = 0;
char[] buffer = new char[partition];
FileWriter fstream = new FileWriter("out.tmp");
do{
    length = reader.read(buffer, position, partition)
    fstream.write(buffer, position, length);
}while(length > 0);
File file = new File("out.tmp");