class FileReader {

private FileHeaderReader headerReader = new FileHeaderReader();
private FileOtherReader otherReader = new FileOtherReader();
//....
private FileInputStream input;

public FileReader(FileInputStream input) {
    this.input = input;
}

public void read() throws IOException {
    Row row = headerReader.read();
    Row[] rows = otherReader.read(row);
    //do something else
}  
}

class FileHeaderReader {
    public Row read() {...}
}
//....