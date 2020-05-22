ConcatInputStream concat = new ConcatInputStream();
System.setIn(concat);

for(int i = 0; i < numberOfCases; i++) {

  Byte[] paramBytes = getCurrentParamBytes();

  InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(paramBytes));

  concat.addInputStream(inputStream);
  String[] params = null;

  testProgram.invoke(null, (Object) params);
}