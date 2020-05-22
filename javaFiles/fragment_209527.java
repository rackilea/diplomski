//write

ByteArrayOutputStream boStream = new ByteArrayOutputStream();
DataOutputStream doStream = new DataOutputStream(boStream);
doStream.writeUTF(myString);
temp.addRecord(boStream.toByteArray(), 0, boStream.size());