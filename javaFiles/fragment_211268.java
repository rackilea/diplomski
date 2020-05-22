public void changeSubtitle(@Nullable String subtitle) {

    if (subtitle == null) {
        toolbar.setLayoutTransition(null);
        getSupportActionBar().setSubtitle(null);
    } else {
        toolbar.setLayoutTransition(new LayoutTransition());
        getSupportActionBar().setSubtitle(subtitle);
    }
}