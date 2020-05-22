JScrollPane js=...; //Create a variable reference to the an instance of scrollpane

JSPlitPane jsp;

js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//set the horizontal scrollbar to never appear

jsp=new JSplitPane(..,js);//create the splitpane with the jscrollpane etc