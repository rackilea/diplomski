ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
OutputStreamWriter out = new OutputStreamWriter(bytesOut, "UTF8");


out.write(yourString);
out.flush();
byte[] tstBytes = bytesOut.toByteArray();