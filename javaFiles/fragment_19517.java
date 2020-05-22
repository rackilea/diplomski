package com.stackoverflow.questions52609313.test;

import com.google.gwt.junit.client.GWTTestCase;
import com.stackoverflow.questions52609313.client.GlobalVariableExtension;
import com.stackoverflow.questions52609313.client.MyJsClass;


public class MainTestGwt extends GWTTestCase {


    @Override
    public String getModuleName() {
        return "com.stackoverflow.questions52609313.test";
    }


    private native String passToJs(MyJsClass myVar)/*-{
        myVar.value = "random";
        return myVar.myMethod();
    }-*/;

    public void testPassToJs() {
        MyJsClass toJs = new MyJsClass();
        toJs.setValue("start");
        toJs.myMethod();
        assertEquals("start", toJs.getValue());
        assertEquals(1, toJs.getCallCounter());

        String ok = passToJs(toJs);
        assertEquals("ok", ok);

        assertEquals("random", toJs.getValue());
        assertEquals(2, toJs.getCallCounter());
    }

    private native MyJsClass createFromJs()/*-{
        var myVar = new $wnd.MyJsClass();
        myVar.value = "random";
        myVar.myMethod();
        return myVar;
    }-*/;

    public void testCreateFromJs() {
        MyJsClass fromJs = createFromJs();

        assertNotNull(fromJs);
        assertEquals("random", fromJs.getValue());
        assertEquals(1, fromJs.getCallCounter());
    }

    private native MyJsClass extractGlobalVariable()/*-{
        return $wnd.myGlobalVariable;
    }-*/;

    public void testExtensionGlobal() {

        GlobalVariableExtension.myGlobalVariable = null;
        MyJsClass myJsClassResultNull = extractGlobalVariable();

        assertNull(myJsClassResultNull);

        String qwerty = "qwerty";
        MyJsClass myJsClass = new MyJsClass();
        myJsClass.setValue(qwerty);
        GlobalVariableExtension.myGlobalVariable = myJsClass;
        MyJsClass myJsClassResult = extractGlobalVariable();

        assertNotNull(myJsClassResult);
        assertEquals(myJsClass, myJsClassResult);
        assertEquals(qwerty, myJsClassResult.getValue());

    }
    private native void popupPanelAction()/*-{
        var popupPanel = new $wnd.GwtPopupPanel();
        popupPanel.show();
        popupPanel.hide();


    }-*/;
    public void testCreatePopupPanel(){
        //expect without exceptions
        popupPanelAction();
    }

}