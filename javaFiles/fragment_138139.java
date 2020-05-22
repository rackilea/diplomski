File target = new File("/path/to/file");
RandomAccessFile file = new RandomAccessFile(target,"rwd");
file.seek(target.length()-1); // Set the pointer to the end of the file
char c = file.readChar();
if(c == '|') // Change the pipe character to whatever your sentinel character is
{
     file.setLength(target.length()-1); // Strip off the last _byte_, not the last character
}