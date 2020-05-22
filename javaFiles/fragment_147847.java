try {
    outputStream = new FileOutputStream(file);
    try {
        InputStream in = ctx.getResources().openRawResource(R.raw.badum2);
        byte[] buffer = new byte[4096];
        int read;
        while ((read = in.read(buffer, 0, buffer.length) >= 0) {
            outputStream.write(buffer, 0, read);
        }
        in.close();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    outputStream.close();
} catch (FileNotFoundException e) {
   e.printStackTrace();
} catch (IOException e) {
   e.printStackTrace();
}