while (j < loop) {
    mgLen = input.readInt();
    input.readFully(message, 0, msgLen); // same assumption as above
    output.writeInt(msgLen);
    output.write(message, 0, msgLen);
    output.flush();
    j++;    
}