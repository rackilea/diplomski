String[] lst = new String[] {"John Smith","John Smith (123)","John Smith (123) (456)"};
Pattern p = Pattern.compile("(.+?)(?:\\s\\((\\d+)\\))?");
for (String s: lst) {
    Matcher m = p.matcher(s);
    if (m.matches()) {
        System.out.println(m.group(1));
        if (m.group(2) != null)
            System.out.println(m.group(2));
    }
}