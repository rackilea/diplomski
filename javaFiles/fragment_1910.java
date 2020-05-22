Pattern errorCodePattern = Pattern.compile("\"code\"\\s*:\\s*\"([^,]*)\",");
Pattern messagePattern = Pattern.compile("\"message\"\\s*:\\s*\"([^,]*)\",");
Pattern statusPattern = Pattern.compile("\"status\"\\s*:\\s*\"(FAILURE)\"");
 Matcher errorCodeMatcher = errorCodePattern.matcher(response);
Matcher messageMatcher = messagePattern.matcher(response);
Matcher statusMatcher = statusPattern.matcher(response);