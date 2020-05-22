val myConf = new Configuration();
    myConf.set("var1", v1)
    myConf.set("var2", v2)
    myConf.set("var3", v3)

val yourFile = sc.newAPIHadoopFile("yourFilePath", classOf[MyFileInputFormat],classOf[org.apache.hadoop.io.Text], classOf[org.apache.hadoop.io.DoubleWritable],myConf)