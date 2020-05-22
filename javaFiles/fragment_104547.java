SwingUtilities.invokeLater(new Runnable() {

    @Override
    public void run() {
        UIManager.put("EditorTabDisplayerUI", "org.foo.NoTabsTabDisplayerUI");
    }
});