String s = "R#GUPW*UIOPW#WERTY*RT#LLOPPPPER*CVW";
List<String> allMatches = new ArrayList<String>();
Pattern p = Pattern.compile("#[^*]+\\*");
Matcher m = p.matcher(s);
while (m.find()) {
    allMatches.add(m.group());
}

for (String str : allMatches) {
    System.out.println(str);
}
>>#GUPW*
>>#WERTY*
>>#LLOPPPPER*