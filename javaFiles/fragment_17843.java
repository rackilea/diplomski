org.apache.avro.SchemaValidationException: Unable to read schema: 
{
  "type" : "record",
  "name" : "pouac",
  "fields" : [ {
    "name" : "test2",
    "type" : "int",
    "aliases" : [ "test1" ]
  } ]
}
using schema:
{
  "type" : "record",
  "name" : "pouac",
  "fields" : [ {
    "name" : "test1",
    "type" : "int"
  }, {
    "name" : "test2",
    "type" : "int"
  } ]
}
    at org.apache.avro.ValidateMutualRead.canRead(ValidateMutualRead.java:70)
    at org.apache.avro.ValidateCanBeRead.validate(ValidateCanBeRead.java:39)
    at org.apache.avro.ValidateAll.validate(ValidateAll.java:51)
    at ca.junctionbox.soavro.Main.main(Main.java:47)
    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke(Method.java:498)
    at org.codehaus.mojo.exec.ExecJavaMojo$1.run(ExecJavaMojo.java:294)
    at java.lang.Thread.run(Thread.java:748)