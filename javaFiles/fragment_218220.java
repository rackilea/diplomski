String replacerRegex = "(\"schedulingCancelModal\": \\{\\s*? \"title\": \")(.+?)(?=\")";
    String value = "\"valueToBePicked\": \"schedulingCancelModal\": {\n \"title\": \"Are you sure you want to leave scheduling?\", ... }";
    Pattern replacerPattern = Pattern.compile(replacerRegex);
    Matcher matcher = replacerPattern.matcher(value);

    while (matcher.find()) {
        String valueToBePicked = matcher.group(2);
        System.out.println(valueToBePicked);
    }