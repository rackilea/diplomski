public class SampleAccessibilityService extends AccessibilityService {

    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AccessibilityNodeInfo source = accessibilityEvent.getSource();
        if (source != null) {
            AccessibilityNodeInfo rowNode = getRootInActiveWindow();
            if (rowNode != null) {
                for (int i = 0; i < rowNode.getChildCount(); i++) {
                    AccessibilityNodeInfo accessibilityNodeInfo = rowNode.getChild(i);
                    if (accessibilityNodeInfo.isEditable() && accessibilityNodeInfo.isFocused()) {
                        accessibilityNodeInfo.performAction(AccessibilityNodeInfoCompat.ACTION_PASTE);
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void onInterrupt() {

    }
}