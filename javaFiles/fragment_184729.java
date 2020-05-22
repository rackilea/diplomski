boolean created = true;
if(!file.getParentFile().exists()) {
    created = file.getParentFile().mkdirs();
}
if (created) {
    String outstring = timestampSDF.format(rightNow) + " | " + data + System.getProperty("line.separator");
    FileOutputStream fos = new FileOutputStream(file, true);
    fos.write(outstring.getBytes());
    fos.close();
}