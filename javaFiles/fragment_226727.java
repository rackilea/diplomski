import java.util.regex.Pattern;

// ...

String characterToReplace = "?";
s = s.replaceFirst(Pattern.quote(characterToReplace), "");