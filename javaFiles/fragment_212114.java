String str = "astv*12atthh124ggh*dhr1234sfff123*dgdfg1234*mnaoj";
Pattern p = Pattern.compile("\\d+");
Matcher m = p.matcher(str);
List<String> strings = new ArrayList<>();
List<Integer> nums = new ArrayList<>();
while (m.find()) {
    nums.add(Integer.parseInt(m.group()));
}
p = Pattern.compile("[a-z]+");
m = p.matcher(str);
while (m.find()) {
    strings.add(m.group());
}
System.out.println(nums);
System.out.println(strings);