String cmd = "\"C:\\Program Files (x86)\\...\\program.exe\" /Enqueue \"%1\"";
StringBuilder sb = new StringBuilder(cmd);
List<String> commands = new ArrayList<>(10);
while (sb.length() > 0) {
    if (sb.charAt(0) == '"') {
        int nextIndex = sb.indexOf("\"", 1);
        if (nextIndex < 0) {
            nextIndex = sb.length();
        } else {
            nextIndex++;
        }
        commands.add(sb.substring(1, nextIndex).replace("\"", ""));
        sb.delete(0, nextIndex);
    } else if (sb.charAt(0) == ' ') {
        if (sb.length() > 1 && sb.charAt(1) != '"') {
            int nextIndex = sb.indexOf(" ", 1);
            if (nextIndex < 0) {
                nextIndex = sb.length();
            }
            commands.add(sb.substring(1, nextIndex));
            sb.delete(0, nextIndex);
        } else {
            sb.delete(0, 1);
        }
    }
}
System.out.println(commands);