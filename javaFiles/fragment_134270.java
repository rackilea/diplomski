package com.databricks.spark.avro

import org.apache.avro.Schema
import org.apache.avro.generic.GenericRecord
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.DataType

object MySchemaConversions {
  def createConverterToSQL(avroSchema: Schema, sparkSchema: DataType): (GenericRecord) => Row =
    SchemaConverters.createConverterToSQL(avroSchema, sparkSchema).asInstanceOf[(GenericRecord) => Row]
}