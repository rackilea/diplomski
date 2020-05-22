private void checkButtons(int page) {
    if(page == 0)
        previous.setEnabled(false);
    if(page != MAX_PAGES)
        next.setEnabled(true);
}

private void resetButtons(int page) {
    previous.setEnabled(true);
    next.setEnabled(false);
    checkButtons(page);
}