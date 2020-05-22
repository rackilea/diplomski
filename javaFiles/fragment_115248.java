/*if (typeof exports === "object" && typeof require === "function") { // we're in a CommonJS (e.g. Node.js) module
    output = exports;
    Converter = require("./Markdown.Converter").Converter;
} else {*/
    output = Markdown;
    Converter = output.Converter;
//}