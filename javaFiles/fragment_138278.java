public MyWidget() {
    initWidget(uiBinder.createAndBindUi(this));
    AppUtils.initializeSomething(this.testElement);
}
public static native void initializeSomething(Element elt)/*-{
    //jQuery lets you wrap a dom element instead of finding it,
    //and we already know where it is
    $wnd.$(elt).doSomeJsStuff();
}-*/;