int height = 0;
int width = 0;

Pattern h = Pattern.compile("height=\"([0-9]*)\"");
Pattern w = Pattern.compile("width=\"([0-9]*)\"");

Matcher m1 = h.matcher(name);
Matcher m2 = w.matcher(name);

if (m1.find()) {
    height = Integer.parseInt(m1.group(1));
}

if (m2.find()) {
    width = Integer.parseInt(m2.group(1));
}

System.out.println(height);
System.out.println(width);