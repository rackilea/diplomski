String buttonsCssSelector = ".indepth-content .content a.meta-icon.download";

Elements buttons = doc.select(buttonsCssSelector);
if (!buttons.isEmpty()) {
   // One or more button(s) exist(s) ...
} else {
   // No button found ...
}