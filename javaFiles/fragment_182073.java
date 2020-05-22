Pattern groupPattern=Pattern.compile("\\[(.*?)\\]([^\\[]*)");
Pattern attrPattern=Pattern.compile("(.*?)=(.*)\\v");
Map<String, Map<String, String>> m;
try(Scanner s=new Scanner(Paths.get(context.io.iniFilename))) {
    m = findAll(s, groupPattern).collect(Collectors.toMap(
        gm -> gm.group(1),
        gm -> results(attrPattern.matcher(gm.group(2)))
            .collect(Collectors.toMap(am->am.group(1), am->am.group(2)))));
}