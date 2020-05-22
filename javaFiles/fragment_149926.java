String sample = "\n    \n   2 \n      \n  \ndl. \n \n    \n flour\n\n     \n 4   \n    \n cups of    \n\nsugar\n";
Pattern p = Pattern.compile("(\\s+)");
Matcher m = p.matcher(sample);
sb = new StringBuffer();
while(m.find())
    m.appendReplacement(sb, " ");
m.appendTail(sb);
System.out.println("Final: [" + sb.toString().trim() + ']');