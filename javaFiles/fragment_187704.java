public _3GPBox(FileInputStream is) throws IOException{
        size = readUint32(is);
        boxSize += 4;
        type = readUint32(is);
        boxSize += 4;
    }