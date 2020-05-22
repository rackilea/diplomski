String[] tokens = locale.toString().split("_");
if (tokens.length >= 2 && tokens[1].length() == 2) {
    joomlaName = tokens[0]+"-"+tokens[1];
} else {
    joomlaName = tokens[0]+"-"+tokens[0].toUpperCase();
}