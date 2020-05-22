public void splitTextFiles(Path bigFile, int maxRows) throws IOException {
    MappedByteBuffer bb;
    try(FileChannel in = FileChannel.open(bigFile, READ)) {
        bb=in.map(FileChannel.MapMode.READ_ONLY, 0, in.size());
    }
    for(int start=0, pos=0, end=bb.remaining(), i=1, lineNum=1; pos<end; lineNum++) {
        while(pos<end && bb.get(pos++)!='\n');
        if(lineNum < maxRows && pos<end) continue;
        Path splitFile = Paths.get(i++ + "split.txt");
        // if you want to overwrite existing files use CREATE, TRUNCATE_EXISTING
        try(FileChannel out = FileChannel.open(splitFile, CREATE_NEW, WRITE)) {
            bb.position(start).limit(pos);
            while(bb.hasRemaining()) out.write(bb);
            bb.clear();
            start=pos;
            lineNum = 0;
        }
    }
}