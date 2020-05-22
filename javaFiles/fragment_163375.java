if (numberAdvice > 1) {
    // Skip inter responses empty line
    input.readLine();
}
StringBuilder sb = new StringBuilder();
String line;
boolean started = false;
while ((line = input.readLine()) != null) {
    if (!started) {
        // Here we check if we reached the end of the header
        if (line.isEmpty()) {
            // Here the body starts
            started = true;
            // Skip chunk start
            input.readLine();
        }
        continue;
    }
    if ("0".equals(line)) {
        // Reached chunk end
        break;
    }
    sb.append(line);
}
System.out.println(sb);