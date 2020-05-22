// Create a JSO and set the properties
Properties p =  Properties.create();
p.set("title", title);
p.set("text", text);
p.set("type", type);

// Get the JSO which has the function we want to call
JavaScriptObject $ = JsUtils.prop(window, "$");

// Call the JS method and get the result (null if the native
// js function returns void
Object ret = JsUtils.runJavascriptFunction($, "pnotify", p);