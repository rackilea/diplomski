public MenuInflater getMenuInflater() {
        // Make sure that action views can get an appropriate theme.
        if (mMenuInflater == null) {
            initWindowDecorActionBar();
            if (mActionBar != null) {
                mMenuInflater = new MenuInflater(mActionBar.getThemedContext(), this);
            } else {
                // initialize instance with context
                mMenuInflater = new MenuInflater(this);
            }
        }
        return mMenuInflater;
    }