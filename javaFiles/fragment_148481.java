StringBuilder sb = new StringBuilder("0000");

while (sb.charAt(0) == '0' && sb.length() > 1)
    sb.deleteCharAt(0);

System.out.println(sb);