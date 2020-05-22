String s = "12.5 mpla 12.5 mpla 121.22 mpla 1.52 mpla 1 mpla 1000 mpla 1000.12 mpla12.5";
StringBuilder sb = new StringBuilder();
for (String token : s.split("\\s+")) {
    if (token.matches("[A-Za-z]+|\\d{1,3}(\\.\\d{1,2})?")) {
        sb.append(token).append(" ");
    }
}
System.out.println(sb.toString());