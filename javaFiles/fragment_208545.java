File source = new File("mySourceFile.txt");
File target = new File("myTargetFile.txt");
int readByteCount = 0;
byte[] buffer = new byte[4096];

try(FileInputStream in = new FileInputStream(source);
    FileOutputStream out = new FileOutputStream(target)) {

    while((readByteCount = in.read(buffer)) != -1) {

        out.write(buffer, 0, readByteCount);
    }
}