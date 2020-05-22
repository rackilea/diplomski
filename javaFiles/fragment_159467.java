Configuration conf = new Configuration();

conf.set("mapreduce.map.memory.mb","4096");
conf.set(mapreduce.reduce.memory.mb","4096");

conf.set(mapreduce.map.cpu.vcores","1");
conf.set(mapreduce.reduce.cpu.vcores","1");