@Override
public void createInitialLayout(IPageLayout layout) {

    ...

    layout.addActionSet(IDebugUIConstants.LAUNCH_ACTION_SET);
    layout.addActionSet(IDebugUIConstants.DEBUG_ACTION_SET);
}