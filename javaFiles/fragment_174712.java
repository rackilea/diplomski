String file = "/dev/ttyS0";
try {
    RandomAccessFile f = new RandomAccessFile(file, "rwd");
} catch (IOException e){
    e.printStackTrace();
}