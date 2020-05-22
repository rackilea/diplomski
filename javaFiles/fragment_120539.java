String p1 = "column1 = emp_no";

String propertyRegexp = "^\\s*(\\w+)\\s*=\\s*(\\w+)\\s*$";

Pattern pattern = Pattern.compile(propertyRegexp);
Matcher matcher = pattern.matcher(p1);
System.out.println("groupCount: " + matcher.groupCount());
if(matcher.matches()) {
    for(int i = 1; i <= matcher.groupCount(); i++) {  //see the changes
        System.out.println(i + ": " + matcher.group(i));    
    }
}