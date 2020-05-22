GridFSDownloadStream st = gridFSBucket.openDownloadStream(filename);
int bufferSize = 1024;
int chunkSize = st.getGridFSFile().getChunkSize();
if (bufferSize > chunkSize)
    bufferSize = chunkSize;
byte[] buffer = new byte[bufferSize];
// Loop
st.read(buffer);