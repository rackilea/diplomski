java.util.List<String> list = new java.util.ArrayList<String>();
Object[] array = list.toArray(); // array.length = 0

IDataCursor cursor = pipeline.getCursor();
IDataUtil.put(cursor, "array", array);
IDataUtil.put(cursor, "array.length", array.length);
cursor.destroy();