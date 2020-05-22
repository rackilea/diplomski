String line;
while((line = file.readLine()) != null)
{
    StringBuilder builder = new StringBuilder(line.length());
    for (int i = 0; i < line.length(); i++) {
        char current = line.charAt(i);
        // Are you sure you want to trim 0?
        if ((current >= '1' && current <= '9') ||
            (current >= 'a' && current <= 'z')) {
            builder.append(current);
        } else if (current >= 'A' && current <= 'Z') {
            builder.append(Character.toLowerCase(current, Locale.US));
        }
    }
    System.out.println(builder);
}