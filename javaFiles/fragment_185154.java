public static boolean isFileLocked(String filename) {
    boolean isLocked=false;
    RandomAccessFile fos=null;
    try {
        File file = new File(filename);
        if(file.exists()) {
            fos=new RandomAccessFile(file,"rw");
        }
    } catch (FileNotFoundException e) {
        isLocked=true;
    }catch (Exception e) {
        // handle exception
    }finally {
        try {
            if(fos!=null) {
                fos.close();
            }
        }catch(Exception e) {
            //handle exception
        }
    }
    return isLocked;
}