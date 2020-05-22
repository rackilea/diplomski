List<byte[]> datas = new ArrayList<byte[]>();

// CODE ... //

FileInputStream fis = new FileInputStream(file);
byte[] buff = new byte[2];
int n
while((n=fis.read(buff))!=-1){
    this.datas.add(buff);
    buff = new byte[2];
}
fis.close();