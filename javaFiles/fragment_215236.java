String template = "aws_%s_xyz";
List<String> codes = new ArrayList<>(Arrays.asList("a", "b"));

for(String code : codes){
    String str = String.format(template, code);
}