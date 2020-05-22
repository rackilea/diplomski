String currentPlayerInfo = "97  Dame Zeraphine [TBC]    10  41.458  481 363 117";

Pattern pattern = Pattern.compile("^[\\d\\s]+(.*?)\\s+\\d");

Matcher matcher = pattern.matcher(currentPlayerInfo);
String currentPlayerName;
if (matcher.find()) {
    currentPlayerName = matcher.group(1);
} else {
    currentPlayerName = null;
}