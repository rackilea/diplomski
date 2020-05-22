tabSheet.addSelectedTabChangeListener(
        (TabSheet.SelectedTabChangeListener) event -> {
            if (tabsheet.getSelectedTab().equals(tab1)) {
                button2.removeClickShortcut();
                button1.setClickShortcut(keyCode, modifier);
            } else {
                button1.removeClickShortcut();
                button2.setClickShortcut(keyCode, modifier);
            }
        });