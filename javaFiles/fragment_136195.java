Path file = ((FileSplit) context.getInputSplit()).getPath();
Path folder = file.getParent();
Configuration conf = context.getConfiguration();
FileSystem fs = FileSystem.get(folder.toUri(), conf);
FileStatus[] statuses = fs.listStatus(folder); // get list of files in folder
for (FileStatus status : statuses) {
    Path f = status.getPath();
    // process file f
}