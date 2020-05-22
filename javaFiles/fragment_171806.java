String baseFile = "c:\\employees";
String fileName = baseFile + ".xls";
int fileCount = 1;
while (true) {
    boolean done = resultSetToExcel.generate(new File(fileName));
    if (done) break;
    fileName = baseFile + "_" + fileCount + ".xls";
    fileCount++;
}