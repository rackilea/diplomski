public void dataWriter(String data, String fileName) {
    File file = getFileStreamPath(fileName);

    if (!file.exists()) {
       file.createNewFile();
    }

    FileOutputStream writer = openFileOutput(file.getName(), Context.MODE_PRIVATE);

    for (String string: data){
        writer.write(string.getBytes());
        writer.flush();
    }

    writer.close();
}