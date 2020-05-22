public class Decoder implements IDecoder {

    @Override
    public void decode(String filePath) throws IOException {

        //read the random access file 
        RandomAccessFile randFile = new RandomAccessFile(filePath, "r");

        //create a string to print the output to console
        StringBuilder builder = new StringBuilder();

        while(true) {
            char c = randFile.readChar();
            builder.append(c);
            int n = randFile.readInt();
            if(n == -1) break;
            randFile.skipBytes(n);

        }

        //print the output and close the random access file 
        System.out.println("The data is" + builder.toString());
        randFile.close();
    }

}