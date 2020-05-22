String[] saDateFilesArr = fileList.list();
for (String saDateFiles : saDateFilesArr) {
    int lastDot = saDateFiles.lastIndexOf('.');
    String strDatefiles = saDateFiles.substring(0, lastDot)
            .replaceAll("\\D", "").concat(saDateFiles.substring(lastDot));
    System.out.println(strDatefiles);
}