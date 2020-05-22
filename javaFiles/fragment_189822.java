@Override
public void onAccessibilityEvent(AccessibilityEvent event) {
    AccessibilityNodeInfo source = event.getSource();
    if (source == null) {
        return;
    } 
    Log.i("Event", event.toString() + ""); 
    Log.i("Source", source.toString() + "");
}