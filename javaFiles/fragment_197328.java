String str = "Русский язык ";
OutputStreamWriter osw = new OutputStreamWriter(
        new FileOutputStream("file path"), "UTF-8"
);
osw.write(str);
osw.flush();
osw.close();