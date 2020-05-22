String fileContent = "S107184CB78120EA52S107184CB78120EA57";
int len = fileContent.length();
List<Byte[]> arrays = new ArrayList<Byte[]>();
List<Byte> data = new ArrayList<Byte>();
for (int i = 0; i < len; i += 2) {
    byte b = (byte) ((Character.digit(fileContent.charAt(i), 16) << 4) + Character.digit(fileContent.charAt(i + 1), 16));
    if (b == -15) {
        arrays.add(data.toArray(new Byte[data.size()]));
        data.clear();
    }
    data.add(b);
}
arrays.add(data.toArray(new Byte[data.size()]));