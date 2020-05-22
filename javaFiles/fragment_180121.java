while (true) {
    try {
        loopCount++;
        read = stdout.read(buffer);
        if(read == -1){
            break;
        }
        output += new String(buffer, 0, read);
        if (read < 128 || loopCount > 5) {
            //we have read everything
            break;
        }
    }catch (Exception e){
        e.printStackTrace();
    }
}