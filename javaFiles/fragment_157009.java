String readBufLine = bufferPcap.readLine();

while (readBufLine!=null){
    StoreLine.add(readBufLine);
    handle.LookForWord(readBufLine);
    readBufLine = bufferPcap.readLine();
}

bufferPcap.close();