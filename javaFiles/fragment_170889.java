((JavascriptExecutor)driver).executeScript(
  "var cells = arguments[0].querySelectorAll('#TDCON > tbody > tr > td:nth-child(4)'); " +
  "var values = arguments[1]; " +
  "for(var i = 0; i < values.length; ++i) { " +
  "  cells[i].querySelector('span > span:nth-child(2) > span > span > input').value = values[i]; " +
  "} "
  , findElement, values);