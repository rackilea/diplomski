Pattern ridPattern = Pattern.compile("RID = (.*)$", Pattern.MULTILINE);
Pattern rtoePattern = Pattern.compile("RTOE = (.*)$", Pattern.MULTILINE);
Matcher ridMatcher = ridPattern.matcher(connectionInfo[0]);
Matcher rtoeMatcher = rtoePattern.matcher(connectionInfo[0]);

if (ridMatcher.find()) {
    rid = ridMatcher.group(1);
}  // else error: no RID
if (rtoeMatcher.find()) {
    rtoe = rtoeMatcher.group(1);
}  // else error: no RTOE

System.out.println("Request ID: " + rid);
System.out.println("Estimated time to completion: " + rtoe + " seconds");