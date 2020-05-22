String[] input = {
            "$_globalVariables/ns:GlobalVariables/VARIABLENAME/ESB/System",
            "$_globalVariables/ns:GlobalVariables/VARIABLENAME2/ESB/System",
            "$_globalVariables/ns:GlobalVariables/VARIABLENAME3/ESB/System" };
Pattern p = Pattern.compile("^\\$_globalVariables/ns:GlobalVariables/(.+?)/ESB/System");
for (String s: input) {
    Matcher m = p.matcher(s);
    if (m.find()) {
        System.out.println("Found: " + m.group());
        System.out.println("\t with variable name: " + m.group(1));
    }
}