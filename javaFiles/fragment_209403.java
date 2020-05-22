Robot bot = new Robot();
bot.setAutoDelay(10);
Thread.sleep(5000);
Map<Character, Integer> mapStrokes = new HashMap<>();
mapStrokes.put('t', KeyEvent.VK_T);
mapStrokes.put('h', KeyEvent.VK_H);
mapStrokes.put('i', KeyEvent.VK_I);
mapStrokes.put('s', KeyEvent.VK_S);
mapStrokes.put(' ', KeyEvent.VK_SPACE);
mapStrokes.put('e', KeyEvent.VK_E);
mapStrokes.put('a', KeyEvent.VK_A);
String text = "This is A test";
for (char value : text.toCharArray()) {
    if (Character.isUpperCase(value)) {
        bot.keyPress(KeyEvent.VK_SHIFT);
    }
    int keyStroke = mapStrokes.get(Character.toLowerCase(value));
    System.out.println("Type " + value);
    bot.keyPress(keyStroke);
    bot.keyRelease(keyStroke);
    if (Character.isUpperCase(value)) {
        bot.keyRelease(KeyEvent.VK_SHIFT);
    }
}