java.util.List<String> list = new java.util.ArrayList<String>();
list.add("item1");
String[] array = list.toArray(new String[0]); // array.length = 1

IDataCursor cursor = pipeline.getCursor();
IDataUtil.put(cursor, "array", array);
IDataUtil.put(cursor, "array.length", array.length);
cursor.destroy();