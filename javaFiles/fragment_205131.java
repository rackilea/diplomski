String inputFile = "C:\Users\...\file.txt";
    FileInputStream in = new FileInputStream(inputFile);
    FileChannel ch = in.getChannel();
    ByteBuffer buf = ByteBuffer.allocate(1024);

    ArrayList<Integer> list = new ArrayList<Integer>();

    int column=-1;
    int row=0;
    int rd;
    while ((rd = ch.read( buf )) != -1){
        buf.flip();
        while (buf.hasRemaining()){
            byte byteVal = buf.get();

            if((byteVal == 48) || (byteVal == 49)){ //ascii code for 0 is 48 and for 1 is 49
                column++;
            }
            if (byteVal == 92){ //ascii code for "/" is 92 as to know when it changes line
                    row++;
                    column=0;
            }
            if(byteVal == 49){
                list.add(column);
                list.add(row);

            }
        }
    buf.clear();
    }
    ch.close();