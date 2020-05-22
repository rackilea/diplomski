List<Byte> bytes = new ArrayList<Byte>();
// [...] Fill the bytes list somehow

List<Integer> integers = new ArrayList<Integer>();
for (Byte b : bytes) {
  integers.add(b == null ? null : b.intValue());
}