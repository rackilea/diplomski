Dataset<Data> ds = ... //1
ds = ds.map(d -> {
  System.out.println(d); //2
  return d; //3
}, Encoders.bean(Data.class));
ds = ds.filter(<filter condition>);
ds.show();