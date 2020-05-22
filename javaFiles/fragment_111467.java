String str = "I am trying to match #эту_строку but ignore the rest.";
Pattern ptrn = Pattern.compile("#(?>\\p{L}\\p{M}*+|_)+");
Matcher matcher = ptrn.matcher(str);
while (matcher.find()) {
    System.out.println(matcher.group(0));
}