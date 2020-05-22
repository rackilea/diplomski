MenuItem mi = null; // TODO

    // Selection
    if (null != mi.getCommand()) {
        mi.getCommand().menuSelected(mi);
    }

    // Toggle checked
    if (mi.isCheckable()) {
        mi.setChecked(!mi.isChecked());
    }