jse.executeScript("function selectElementContents(el) {
    var range = document.createRange();
    range.selectNodeContents(el);
    var sel = window.getSelection();
    sel.removeAllRanges();
    sel.addRange(range);
}

var el = document.querySelector('h1.tiptitle');
selectElementContents(el);");