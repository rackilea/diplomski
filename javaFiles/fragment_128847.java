String x = "Hello, World!";
StringBuilder sb = new StringBuilder();
for (char c : x.toCharArray()) {
    if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')) {
        sb.append(c);
    }
}
System.out.println(sb.toString());