engine.getLoadWorker().stateProperty().addListener(
        new ChangeListener<State>() {
        @Override
        public void changed(ObservableValue ov, State oldState, State newState) {
            if (newState == State.SUCCEEDED) {
                engine.executeScript(
   "var myParam = location.search.split('find=')[1];"
 + "doSearch(myParam);function doSearch(text) {\n" +
   "        if (window.find && window.getSelection) {\n" +
   "        document.designMode = \"on\";\n" +
   "        var sel = window.getSelection();\n" +
   "        sel.collapse(document.body, 0);\n" +
   "\n" +
   "        while (window.find(text)) {\n" +
   "            document.execCommand(\"HiliteColor\", false, \"yellow\");\n" +
   "            sel.collapseToEnd();\n" +
   "        }\n" +
   "        document.designMode = \"off\";\n" +
   "    } else if (document.body.createTextRange) {\n" +
   "        var textRange = document.body.createTextRange();\n" +
   "        while (textRange.findText(text)) {\n" +
   "            textRange.execCommand(\"BackColor\", false, \"yellow\");\n" +
   "            textRange.collapse(false);\n" +
   "        }\n" +
   "    }\n" +
   "}");
            }
        }
    });