Configuration config = new Configuration();
Path path = new Path(PATH_TO_YOUR_FILE);
SequenceFile.Reader reader = new SequenceFile.Reader(FileSystem.get(config), path, config);
WritableComparable key = (WritableComparable) reader.getKeyClass().newInstance();
Writable value = (Writable) reader.getValueClass().newInstance();
while (reader.next(key, value))
  // perform some operating
reader.close();