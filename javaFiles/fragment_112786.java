// in main
public static final String CONF_LEN = "conf.len";
...
conf.setInt(CONF_LEN, 3);

// in mapper
@Override
protected void setup(Mapper<Object, Text, Text, Text>.Context context) throws IOException, InterruptedException {
  super.setup(context);
  this.len = context.getConfiguration().getInt(CONF_LEN, -1);
}