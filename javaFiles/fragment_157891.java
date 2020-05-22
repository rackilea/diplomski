if (file.isDirectory()) {
    return false;
}

File directory = new File(context.getInstallationDirectory(), "/lib");
if (!directory.exists()) {
    return false;
}

List<File> subDirs = new ArrayList<>();
File[] delinquents = directory.listFiles();
for (File delinquent : delinquents) {
    if (delinquent.isDirectory()) {
        subDirs.add(delinquent);   
    }
}

for (File sub : subDirs) {

    File[] filesInLib = sub.listFiles();
    for(File theFile : filesInLib) {
        if (theFile.equals(file))
        {
            Util.logInfo(null, "Delete " + file.getAbsolutePath());
            return true;
        }
    }
}
return false;