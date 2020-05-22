public static HashMap<Integer, VectorWritable> readCentroids(Configuration conf, Path path)
        throws IOException {
    HashMap<Integer, VectorWritable> centroids = new HashMap<Integer, VectorWritable>();
    FileSystem fs = FileSystem.get(path.toUri(), conf);
    FileStatus [] list = fs.globStatus(new Path(path, "part-*"));
    for (FileStatus status : list) {
        SequenceFile.Reader reader = new SequenceFile.Reader(fs, status.getPath(), conf);
        IntWritable key = null;
        VectorWritable value = null;
        try {
            key = (IntWritable)reader.getKeyClass().newInstance();
            value = (VectorWritable)reader.getValueClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        while (reader.next(key, value)) {
            centroids.put(new Integer(key.get()),
                    new VectorWritable(value.get(), value.getClusterId(), value.getNumInstances()));
        }
        reader.close();
    }
    return centroids;
}