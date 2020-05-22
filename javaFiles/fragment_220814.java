Pattern p = Pattern.compile(PATTERN);
 Matcher m = p.matcher(INPUT_SOURCE);

 StringBuffer sb = new StringBuffer();
 while (m.find()) {
     m.appendReplacement(sb, REPLACEMENT);
 }
 m.appendTail(sb);

 System.out.println(sb.toString());