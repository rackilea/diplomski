@Override
public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent){
    int eventType = accessibilityEvent.getEventType();

switch (eventType) {

    case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:

        AccessibilityNodeInfo rootNode = getRootInActiveWindow();
        ArrayList<AccessibilityNodeInfo> buttonNodes = new ArrayList<AccessibilityNodeInfo>();

        findChildViews(rootNode);

        for(AccessibilityNodeInfo mNode : buttonNodes){
            if(mNode.getText()==null){
                return;
            }
            if(mNode.getText().toString().contentEquals("FORCE STOP"){
                mNode.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }

        }
        break;

 }
}