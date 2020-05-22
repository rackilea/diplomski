Pattern p = Pattern.compile("[wow]*"); // One of the two 'w's is redundant, but the engine is OK with it
Matcher m = p.matcher("");             // Passing an empty string results in a valid match that is empty
boolean b = false;
while (b = m.find()) {
    System.out.print(m.start() + " \"" + m.group() + "\" ");
}