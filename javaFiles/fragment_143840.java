String fileName = "file.txt";
    String content = "hello world";

    FileOutputStream outputStream = null;
    try {
       outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
       outputStream.write(content.getBytes());
       outputStream.close();
} catch (Exception e) {
    e.printStackTrace();
}