class CustomItem extends org.eclipse.jface.action.ContributionItem {

 @Override
    public void fill(final ToolBar toolBar, final int index) {
      final ToolItem toolItem = new ToolItem(toolBar, SWT.PUSH);
        toolItem.setText("Sample Tool Item 1");
        toolItem.setEnabled(false);
        toolItem.setToolTipText("Sample Tool Tip 1");

        final ToolItem toolItem2 = new ToolItem(toolBar, SWT.PUSH);
        toolItem2.setText("Sample Tool Item 2");
        toolItem2.setToolTipText("Sample Tool Tip 2");

    }
}