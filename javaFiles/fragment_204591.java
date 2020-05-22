BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

String line;
List<String> headers = new LinkedList<>();
StringBuilder body = null;
while ((line = in.readLine()) != null) {
    //- Here we test if we've reach the body part.
    if (line.isEmpty() && body == null) {
        body = new StringBuilder();
        continue;
    }
    if (body != null) {
        body.append(line).append('\n');
    }
    else {
        headers.add(line);
    }
}

System.out.println("--- Headers ---");
for (String h : headers) {
    System.out.println(h);
}
System.out.println("--- Body ---");
System.out.println(body != null ? body.toString() : "");