String data = "a really long string";
Field field = String.class.getDeclaredField("value");
field.setAccessible(true);
char[] chars = (char[]) field.get(data);

for (int i = 0, n = chars.length; i < n; i++)
    System.out.println(chars[i]);