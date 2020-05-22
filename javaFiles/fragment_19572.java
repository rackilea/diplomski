public String formatNumbers(String input) {
  Pattern p = Pattern.compile("\\d+");
  Matcher m = p.matcher(input);
  NumberFormat nf = NumberFormat.getInstance();        
  StringBuffer sb = new StringBuffer();
  while(m.find()) {
    String g = m.group();
    m.appendReplacement(sb, nf.format(Double.parseDouble(g)));            
  }
  return m.appendTail(sb).toString();
}