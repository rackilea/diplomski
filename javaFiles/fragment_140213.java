Pattern correct = Pattern.compile("\\<font color=.*?\\>", 0);
Pattern replace = Pattern.compile("\\</?(font|b|br/)( +.*?)?\\>", 0);

for (String s : Files.readAllLines(myfile)) {
    if (correct.matcher(s).matches() && replace.matcher(s).matches()) {
        String text = replace.matcher(s).replaceAll("");

        String time = text.substring(1, text.indexOf(')'));

        int offset = text.indexOf(':');
        offset = text.indexOf(':', offset + 1);
        int result = text.indexOf(':', offset + 1);

        String name = text.substring(text.indexOf(')') + 2, result);
        String message = text.substring(result + 2).trim();

        // do stuff with time, name and message
    }
}