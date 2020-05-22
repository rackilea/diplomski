String html = myPanel.getElement().getInnerHTML();
print(html);


public static final native void print(String html) /*-{

    top.consoleRef=$wnd.open('','_blank', "");
    top.consoleRef.document.write(html);
    top.consoleRef.print();
    top.consoleRef.document.close()

}-*/;