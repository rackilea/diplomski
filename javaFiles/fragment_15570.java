protected void clickScreen(final AccessibilityNodeInfo source, final String text)
{
new Handler().postDelayed(new Runnable() {
    //Find ALL of the nodes that match the "text" argument.
    List<AccessibilityNodeInfo> list = source.findAccessibilityNodeInfosByText(text);
    @Override
    public void run() {
        //Non discrliminintly click them, whether they're buttons, or text fields or links... just click them and hope they do something.
        for (final AccessibilityNodeInfo node : list) {
            node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }
    }
//Delay it for a second AFTER the function has been called for no particularly good reason besides perhaps invalidating all of the nodes in the heirarchy... GOOD CALL!
}, 1000);
}