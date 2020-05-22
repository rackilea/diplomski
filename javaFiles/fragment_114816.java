final String command = "somescript.file $(ABC_PATH1) $(ENV_PATH2) <may be other args too here>";
final String pattern = "\\$\\((\\w+)\\)";

final Pattern pr = Pattern.compile(pattern);
final Matcher match = pr.matcher(command);
while (match.find()) {
    System.out.println("Found value: " + match.group(1));
}