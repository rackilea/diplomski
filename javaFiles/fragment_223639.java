DataInputStream in = new DataInputStream (recording.getInputStream());
FileOutputStream videoFile = new FileOutputStream(targetFile);
int len;
byte buffer[] = new byte[8192];

while((len = in.read(buffer)) != -1) {
    videoFile.write(buffer, 0, len);
}

videoFile.close();