wApp->require("lib/ace/ace.js")
// A WContainerWidget is rendered as a div
WContainerWidget *editor = new WContainerWidget(parent);
// editor->jsRef() is a text string that will be the element when executed in JS
editor->doJavaScript(
    editor->jsRef() + ".editor = ace.edit(" + editor->jsRef() + ");" +
    editor->jsRef() + ".editor.setTheme('ace/theme/monokai');" +
    editor->jsRef() + ".editor.getSession().setMode('ace/mode/javascript');"
  );