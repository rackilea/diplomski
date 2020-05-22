String str = "${name}/${family}/${child}/${fname}";
Pattern pat = Pattern.compile("\\$\\{(\\w+)\\}");
Matcher mat = pat.matcher(str);
List<String> al = new ArrayList<>();
while (mat.find()) {
    al.add(mat.group(1));
}
System.out.println(al);