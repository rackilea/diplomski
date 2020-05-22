public void hideFirstRow() {
        if (headerShowing) {
            appsList.remove(0);
            notifyItemRemoved(0);
            headerShowing = false;
        }
    }