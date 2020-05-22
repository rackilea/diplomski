public static void main(String[] args) {
    String template = "Hello {user}, your  request id is {id}.";
    String withValues = "Hello ABC , your  request id is 1234.";

    String patternFromTemplate = template.replaceAll("\\.", "\\\\."); // escape "." 
    patternFromTemplate = patternFromTemplate.replace("{user}", "(.*)"); // capturing group 1
    patternFromTemplate = patternFromTemplate.replace("{id}", "(.*)"); // capturing group 2

    Pattern p = Pattern.compile(patternFromTemplate);
    Matcher m = p.matcher(withValues);
    if (m.matches()) {
        System.out.println("{user} = "+m.group(1));
        System.out.println("{id}   = "+m.group(2));
    } 
}