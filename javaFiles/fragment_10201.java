@Override
    public void reduce(NullWritable Key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        for (Text value : values) {

            final String valueStr = value.toString();
            StringBuilder sb = new StringBuilder();
            if (valueStr.contains("Japan")) {
                sb.append(valueStr.substring(0, valueStr.length() - 20));
            } else if (valueStr.contains("SelfSourcedPrivate")) {
                sb.append(valueStr.substring(0, valueStr.length() - 24));
            } else if (valueStr.contains("SelfSourcedPublic")) {
                sb.append(value.toString().substring(0, valueStr.length() - 25));
            } else if (valueStr.contains("ThirdPartyPrivate")) {
                sb.append(valueStr.substring(0, valueStr.length() - 25));
            }
            multipleOutputs.write(NullWritable.get(), new Text(sb.toString()),
                    strName);
        }
    }