List<Integer> items = ...;
ByteArrayOutputStream baos = new ByteArrayOutputStream();
DataOutputStream stream = new DataOutputStream(baos);
stream.write(items.size());
for (Integer item : items) {
    stream.writeInt(item);
}
stream.flush(); // not sure this is strictly necessary
byte[] result = baos.toByteArray();