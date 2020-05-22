public FirstPanel() {

    History.addHistoryListener(this);
    String token = History.getToken();
    if (token.length() == 0) {
        History.newItem(INIT_STATE);
    } else {
        History.fireCurrentHistoryState();
    }

    .. rest of code