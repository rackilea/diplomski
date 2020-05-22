package com.example

import org.apache.spark.sql.UserDefinedFunction
import org.apache.spark.sql.functions.udf

class MyUdf extends Serializable {
  def getUdf: UserDefinedFunction = udf(() => MyJavaClass.MyJavaMethod())
}