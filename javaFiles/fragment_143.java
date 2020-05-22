String text = "This.IS(a) text example blah? bl:ah";
// Edit: now with removed escapes when not necessary - thanks hwnd
//              ┌ original character class
//              |          ┌ greedy quantifier: "one or more times"
//              |          |
String regex = "[\\s?.:;)(]+";
String[] splittedText = text.split(regex);
System.out.println(Arrays.toString(splittedText));