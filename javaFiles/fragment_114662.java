int i;
int num_f = 10;
int num_d = 194672;

File folder = new File(route);
File[] listOfFiles = folder.listFiles();

float double_list[][] = new float[num_f][num_d];

for (int file = 0; file < listOfFiles.length; file++) {
    if (listOfFiles[file].isFile()) {
        try{
           fc = (FileChannel) Files.newByteChannel(Paths.get(listOfFiles[file].getAbsolutePath()), StandardOpenOption.READ);
           byteBuffer = ByteBuffer.allocate((int)fc.size());
           byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
           fc.read(byteBuffer);
           byteBuffer.flip();

           buffer = byteBuffer.asDoubleBuffer();
           ((DoubleBuffer)buffer).get(double_list[file]);
           byteBuffer.clear();

           fc.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                //Close file
                br.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
 }