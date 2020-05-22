private void findChildViews(AccessibilityNodeInfo parentView) {
        if (parentView == null || parentView.getClassName() == null || ) {
            return;
        }

        if (childCount == 0 && (parentView.getClassName().toString().contentEquals("android.widget.Button"))) {
            buttonNodes.add(parentView);
        } else {
            for (int i = 0; i < childCount; i++) {
                findChildViews(parentView.getChild(i));
            }
        }
    }
}