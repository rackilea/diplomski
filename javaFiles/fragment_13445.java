Pattern pattern = Pattern.compile("(-?\\d+)");
Matcher matcher = pattern.matcher(str);
while (matcher.find()) {
    nums.add(Integer.parseInt(matcher.group()));
}

Collections.sort(nums);
System.out.println(nums);