Pattern pattern = Pattern.compile("<([^:]+:InsurerId)>([^<]*)</\\1>");
Matcher matcher = pattern.matcher(abc);

if (matcher.find()) {
    System.out.println(matcher.group(2));
}