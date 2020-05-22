StringBuilder sb = new StringBuilder();
boolean targetFound = false;
for (String line : lines) {
    if (line.startsWith("IN:")) {
        line = line.replace("IN:", "");
        targetFound = false;
    } else if (line.startsWith("OUT:")) {
        targetFound = true;
    }

    if (targetFound && !line.equals("OUT:")) {
        // Print
        System.out.println(sb.toString());
        sb.setLength(0);
    } else {
        sb.append(line.trim());
    }
}