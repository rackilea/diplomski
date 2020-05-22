// for each line
if(patternString.length() > 0) patternString.append("|");
patternString.append("(?:" + line + ")");

//...
return Pattern.compile(patternString.toString());