"use strict";
/**
 * Text foundation component JS backing script
 */
use(["/apps/global/components/utils/AuthoringUtils.js"], function (AuthoringUtils) {

var CONST = {
    PROP_TEXT: "text",
    PROP_RICH_FORMAT: "textIsRich",
    CONTEXT_TEXT: "text",
    CONTEXT_HTML: "html"
};

var text = {};

// The actual text content
text.text = granite.resource.properties[CONST.PROP_TEXT]
        || "";

// Wether the text contains HTML or not
text.context = granite.resource.properties[CONST.PROP_RICH_FORMAT]
        ? CONST.CONTEXT_HTML : CONST.CONTEXT_TEXT

// Set up placeholder if empty
if (!text.text) {
    text.cssClass = AuthoringUtils.isTouch
            ? "cq-placeholder"
            : "cq-text-placeholder-ipe";
    text.context = CONST.CONTEXT_TEXT;

    // only dysplay placeholder in edit mode
    if (typeof wcmmode != "undefined" && wcmmode.isEdit()) {
        text.text = AuthoringUtils.isTouch
        ? ""
        : "Edit text";
    } else {
        text.text = "";
    }
}

// Adding the constants to the exposed API
text.CONST = CONST;

return text;