//ExpectedConditions.jsReturnsValue
String javaScript = "(function watcher(ms){var start=new Date().getTime();var end = start;while(end<start+ms){end=new Date().getTime();};return 'complete';})(5000);return 'success';";
log.trace("javaScript={}", javaScript);
Object jsResult = wait.until(ExpectedConditions.jsReturnsValue(javaScript));
log.trace("jsResult={}", jsResult);

//ExpectedConditions.javaScriptThrowsNoExceptions
javaScript = "(function watcher(ms){var start=new Date().getTime();var end = start;while(end<start+ms){end=new Date().getTime();};return 'complete';})(5000);";
log.trace("javaScript={}", javaScript);
jsResult = wait.until(ExpectedConditions.javaScriptThrowsNoExceptions(javaScript));
log.trace("jsResult={}", jsResult);