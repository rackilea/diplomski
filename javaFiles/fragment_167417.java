String line;
StringBuilder sb = new StringBuilder();

while ((line = in.readLine()) != null) {
    sb.append(line);
    sb.append("\n");
    System.out.println(line);
}

String content = sb.toString();