{
  "type" : "record",
  "name" : "MyRecord",
  "namespace" : "org.demo",
  "fields" : [ {
    "name" : "timestamp_with_logical_type",
    "type" : {
      "type" : "long",
      "logicalType" : "timestamp-millis"
    }
  }, {
    "name" : "timestamp_no_logical_type",
    "type" : "long"
  } ]
}