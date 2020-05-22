String value = "abc";
StringBuilder sb = new StringBuilder();

sb.append(value.subString(0, 1));
sb.append("X");
sb.append(value.subString(1, value.length()));