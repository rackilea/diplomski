Iterator<String> itr = request.getFileNames();

/* Iterate each file, there should only be one/one chunk */
while (itr.hasNext()) {
    fileUploaded = request.getFile(itr.next());
    raf.write(fileUploaded.getBytes());
}

raf.close();