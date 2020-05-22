Pattern pattern = Pattern.compile("0{2,}|1{2,}");
Matcher matcher = pattern.matcher(input);

while (matcher.find()) {
    System.out.println(matcher.start());
}