FileInputStream fis;
fis = openFileInput("sample.txt");
StringBuffer Content = new StringBuffer("");

byte[] buffer = new byte[1024];
int length;
while ((length = fis.read(buffer)) != -1) {
    Content.append(new String(buffer));
}

you will get entire content in a string buffer ,convert it into string, then you can apply yourString.split(";") to get all values which you can keep in some array.