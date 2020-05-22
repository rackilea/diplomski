// Writing to a string is a potential performance and memory issue
final Writer out = new StringWriter();
final JsonWriter jsonWriter = new JsonWriter(out);
jsonWriter.setIndent("\t");
DirectoryWalk.walk(root, ToFlatJsonArrayDirectoryWalkListener.get(jsonWriter));
System.out.println(out);