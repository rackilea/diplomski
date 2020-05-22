RandomAccessFile file = new RandomAccessFile(new File(fileName), "r");
long index, length;
length = file.length() - 1; 
for (index = length; index >= 0; index--) {
    file.seek(index);
    int s = file.read();
    //..
}
file.close();