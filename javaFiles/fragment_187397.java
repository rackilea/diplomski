public void click(int x, int y) {

    clickAtPosition(x, y, getRootInActiveWindow());
}

public static void clickAtPosition(int x, int y, AccessibilityNodeInfo node) {
    if (node == null) return;

    if (node.getChildCount() == 0) {
        Rect buttonRect = new Rect();
        node.getBoundsInScreen(buttonRect);
        if (buttonRect.contains(x, y)) {
            // Maybe we need to think if a large view covers item?
            node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            System.out.println("1º - Node Information: " + node.toString());
        }
    } else {
        Rect buttonRect = new Rect();
        node.getBoundsInScreen(buttonRect);
        if (buttonRect.contains(x, y)) {
            // Maybe we need to think if a large view covers item?
            node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            System.out.println("2º - Node Information: " + node.toString());
        }
        for (int i = 0; i < node.getChildCount(); i++) {
            clickAtPosition(x, y, node.getChild(i));
        }
    }
}