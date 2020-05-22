List<String> strList = Arrays.asList(
    "app_Usage_RTIS/batch_id=11111/abc",
    "ENV_RTIS/batch_id=22222/",
    "ABCD-EFG_RTIS/batch_id=33333/",
    "/RTIS/batch_id=44444/",
    "/batch_id=55555/"
);

Pattern pattern = Pattern.compile(".*(?<!_RTIS)/batch_id=(\\d+)/.*");
for (String s : strList) {
    if (pattern.matcher(s).matches()) {
        System.out.println(s + "\tTrue");
    }
}