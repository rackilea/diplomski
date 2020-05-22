private static final int CHARS = 256;     
private int [] getByteFrequency(File f) throws FileNotFoundException {
    try {
        FileInputStream fis = new FileInputStream(f);
        byte [] bb = new byte[(int) f.length()];
        int [] aa = new int[CHARS];
            if(fis.read(bb) == bb.length) {
                System.out.print("Uncompressed data: ");
                for(int i = 0; i < bb.length; i++) {
                        System.out.print((char) bb[i]);
                        aa[((int)bb[i])&0xff]++;
                }
                System.out.println();
            }
        return aa;
    } catch (FileNotFoundException e) { throw new FileNotFoundException(); 
    } catch (IOException e) { e.printStackTrace(); }
    return null;
}