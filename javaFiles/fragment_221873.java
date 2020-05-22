protractor.ElementFinder.prototype.getTextContent = function () {
    // inject script on the page
    return this.ptor_.executeScript(function () {
        // note: this is not a Protractor scope

        // current element
        var el = arguments[0];
        var text = '';

        for (var i = 0, l = el.childNodes.length; i < l; i++) {
            // get text only from text nodes
            if (el.childNodes[i].nodeType === Node.TEXT_NODE) {
                text += el.childNodes[i].nodeValue;
            }
        }

        // if you want to exclude leading and trailing whitespace
        text = text.trim();

        return text; // the final result, Promise resolves with this value

    }, this.getWebElement()); // pass current element to script
};