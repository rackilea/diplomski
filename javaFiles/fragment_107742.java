JobConf conf = ...;

// You should probably pass this in as parameter rather than hardcoding 4.
conf.setInt("outputs.per.reducer", 4);

// This sets up the infrastructure to write multiple files per reducer.
MultipleOutputs.addMultiNamedOutput(conf, "multi", YourOutputFormat.class, YourKey.class, YourValue.class);