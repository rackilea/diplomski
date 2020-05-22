Command delete = new Command() {
        public void execute() {
            removeDialog(DIALOG_WIFI_PREF);
            showDialog(DIALOG_WIFI_PREF);
        }
    };