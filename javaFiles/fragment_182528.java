imagFileName = Integer.toString(i) +".jpg";         
InputStream input = new FileInputStream(new File(dirName, imagFileName));
try {
    copy(input, baos);
}
finally {
    input.close();
}