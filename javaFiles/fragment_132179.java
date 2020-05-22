menuItem.setUI(new MotifMenuItemUI() {
    @Override
    protected void doClick(MenuSelectionManager msm) {
        menuItem.doClick(0);
    }
});