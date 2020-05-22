@Override
public void onAccessibilityEvent(AccessibilityEvent event) {
    AccessibilityNodeInfo source = event.getSource(); 
    if (source == null) {
        return; 
    } 
    List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = source.findAccessibilityNodeInfosByViewId("YOUR PACKAGE NAME:id/RESOURCE ID FROM WHERE YOU WANT DATA"); 
    if (findAccessibilityNodeInfosByViewId.size() > 0) {
        AccessibilityNodeInfo parent = (AccessibilityNodeInfo) findAccessibilityNodeInfosByViewId.get(0);
        // You can also traverse the list if required data is deep in view hierarchy. 
        String requiredText = parent.getText().toString();
        Log.i("Required Text", requiredText);
    }
}