BufferedInputStream bis = null;
BufferedOutputStream bos = null;

try {
    bis = new BufferedInputStream(new FileInputStream(sourceFile));
    bos = new BufferedOutputStream(new FileOutputStream(targetFile));

    int theByte;

    while((theByte = bis.read()) != -1)
    {
        bos.write(theByte);
    }

    bos.close();
    bis.close();
    // You may want to verify that the file's are the same (ie the file size for example)
    if (!sourceFile.delete()) {
        throw new IOException("Failed to remove source file " + sourceFile);
    }

} catch (IOException exp) {
    exp.printStackTrace();
} finally {
    try {
        bis.close();
    } catch (Exception exp) {
    }
    try {
        bos.close();
    } catch (Exception exp) {
    }
}