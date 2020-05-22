Robot bot = new Robot();
bot.setAutoDelay(250);
bot.keyPress(KeyEvent.SHIFT_KEY);
bot.keyPress(KeyEvent.EQUALS); // Shift + "=" = +
bot.keyRelease(KeyEvent.EQUALS);
bot.keyRelease(KeyEvent.SHIFT_KEY);