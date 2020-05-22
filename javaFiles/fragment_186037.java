if(item != null && item.isEnabled() == false) {
        // "Undim" the icon
        item.getIcon().setAlpha(255);
        // Enable it again
        item.setEnabled(true);
    }