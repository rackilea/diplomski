@Override
    public void map(LongWritable key, Text value, Context context) throws IOException {
        try {
            if (key.get() == 0 && value.toString().contains("header") /*Some condition satisfying it is header*/)
                return;
            else {
                // For rest of data it goes here
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }