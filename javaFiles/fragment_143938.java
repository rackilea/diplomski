private native void fireRCPEvent(String rcpEventJSON) /*-{
 try{
    $wnd.onGWTEvent(rcpEventJSON); //notice the usage of $wnd object
 } catch(e) {
    alert(e.message)
 }
}-*/