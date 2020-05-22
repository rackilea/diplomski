if (path.equals("")) {
    zip.putNextEntry(new ZipEntry(folder.getName()));
}
else {
    zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
}