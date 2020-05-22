try {
    while(true){
        cmd += (char) reader.readByte();
    }
} catch (EOFException e) {
    // handle EOF
}

/* end of the stream reached */
processInput(cmd);

System.out.println("End of the loop");