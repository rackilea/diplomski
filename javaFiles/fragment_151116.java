//Read allfiles.txt and put each line into a List (requires at least Java 1.7)
List<String> files = Files.readAllLines(Paths.get("allfiles.txt"), StandardCharsets.UTF_8);

/Loop through the file names and add them as input
for(String file : files) {
     //This Path is org.apache.hadoop.fs.Path 
     FileInputFormat.addInputPath(conf, new Path(file));
}