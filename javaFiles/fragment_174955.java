Path pattern = new Path("/tmp/input/*/*/*/*/filename")    
FileSystem fs = FileSystem.get(conf);
FileStatus[] statuses = fs.globStatus(pattern);
long total = 0;
for (FileStatus file : statuses) {
    total += file.getLen();
}