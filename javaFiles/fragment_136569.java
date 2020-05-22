public void setupUI(View view) {

    if(!(view instanceof SearchView)) {

        view.setOnTouchListener(new OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                searchMenuItem.collapseActionView();
                return false;
            }

        });
    }

    //If a layout container, iterate over children and seed recursion.
    if (view instanceof ViewGroup) {

        for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {

            View innerView = ((ViewGroup) view).getChildAt(i);

            setupUI(innerView);
        }
    }
}