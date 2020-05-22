String data = "abcdefghij";
StringBuilder sb = new StringBuilder(data);
for (int i = sb.length() - 4; i > 0; i -= 4)
    sb.insert(i, ' ');
data = sb.toString();
System.out.println(data);