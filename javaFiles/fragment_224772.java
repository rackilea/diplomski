String input = "u2x4m5x7";
Pattern pattern = Pattern.compile("\\d+x");
Matcher m = pattern.matcher(input);
StringBuilder b = new StringBuilder();

while(m.find()) {
    b.append(m.group(0));
}

System.out.println(b)