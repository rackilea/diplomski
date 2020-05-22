String JS_CLICK_TRIPLE = 
  "var target = arguments[0];                                 " +
  "var offsetX = arguments[1];                                " +
  "var offsetY = arguments[2];                                " + 
  "var rect = target.getBoundingClientRect();                 " +
  "var cx = rect.left + (offsetX || (rect.width / 2));        " +        
  "var cy = rect.top + (offsetY || (rect.height / 2));        " +
  "                                                           " +
  "emit('mousedown', {clientX: cx, clientY: cy, buttons: 1}); " +
  "emit('mouseup',   {clientX: cx, clientY: cy});             " +
  "emit('mousedown', {clientX: cx, clientY: cy, buttons: 1}); " +
  "emit('mouseup',   {clientX: cx, clientY: cy});             " +
  "emit('mousedown', {clientX: cx, clientY: cy, buttons: 1}); " +
  "emit('mouseup',   {clientX: cx, clientY: cy});             " +
  "emit('click',     {clientX: cx, clientY: cy, detail: 3});  " +
  "                                                           " +
  "function emit(name, init) {                                " +
    "target.dispatchEvent(new MouseEvent(name, init));        " +
  "}                                                          " ;


Actions action1 = new Actions(driver);
action1.moveToElement(yourElement, posX, posY).perform();

((JavascriptExecutor)driver).executeScript(
    JS_CLICK_TRIPLE, yourElement, posX, posY);