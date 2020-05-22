static void clickFirstMatchingNode(AccessibilityService service, final String text) {
    final List<AccessibilityNodeInfo> list = service.getRootInActiveWindow().findAccessibilityNodeInfosByText(text);

    for (AccessibilityNodeInfo node : list) {

       //Check if the action completely successfully. Also, only click one of them. This is kind of an assumption, it also simplifies the logic. You can certainly write a version of this that clicks everything that matches!
        if (node.performAction(AccessibilityNodeInfo.ACTION_CLICK)) return;

    }

    //If no node is successfully clicked Log some stuff!
    Log.wtf(YourService.class.getName(), "Failed to click any nodes! WTF?: " + text);
}