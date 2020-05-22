String str3 = "0.0 0.0503    0.0485  0.0481  0.0491  0.0494  0.0489  0.0482  0.0485  0.0479  0.0487  0.0495  0.0487";    

Pattern dataLinePattern = Pattern
        .compile(".*\\s+((\\d+(\\.\\d+)?)(\\s+(\\d+(\\.\\d+)?)){11})\\s*$");
Matcher m = dataLinePattern.matcher(str3);

if (m.matches()) {
    System.out.println(m.group().trim().replaceAll("\\s+", " "));
}