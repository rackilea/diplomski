String s = "225:org.powertac.common.Competition::0::new::game-0";
Pattern p = Pattern.compile("([^:]+):([^:]+)::([\\d]+)::([^:]+)::(.+)");
Matcher m = p.matcher(s);
if (m.find()) {
  String id = m.group(1);
  String className = m.group(2);
  int orderOfExecution = Integer.valueOf(m.group(3));
  String methodNameOrNew = m.group(4);
  String[] arguments = m.group(5).split("::");
}