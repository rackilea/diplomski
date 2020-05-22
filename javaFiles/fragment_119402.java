long sleepDuration = 10000;
ArrayList<File> newFileList;
int counter = 10;

while (counter-- > 0) {
    newFileList = listLastModifiedFiles(folder, sleepDuration);

    for (File File : newFileList)
        System.out.println(File.getName());

    Thread.sleep(sleepDuration);
}