StringBuilder sourceBuilder = new StringBuilder();
sourceBuilder.append("package com.example.beans;\n\n");
sourceBuilder.append("import java.util.*;\n\n");
sourceBuilder.append("public class MyBean {");

for (DBField dbField:getFieldsFromDatabaseModel) {  // this DBField class is pure fiction!
  // bean attribute
  sourceBuilder.append("\tprivate ")
               .append(dbField.getType)
               .append(toFieldName(dbField.getName()))
               .append(" = null;\n");

  // setter method
  sourceBuilder.append("\tpublic void ")
               .append(toSetterName(dbField.getName()))
               .append("(");
               .append(dbField.getType)
               .append(toFieldName(dbField.getName()))
               .append(")\n")
               .append("\t\tthis.")
               .append(dbField.getType)
               .append(" = ")
               .append(dbField.getType)
               .append(";\n\t}");

   // getter method ...
sourceBuilder.append("\t}\n}\n");