private void setupListeners() {

    final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.add_record);
    if (linearLayout != null) {
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Clicking ll");
                noteEditText.requestFocus();

                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInputFromWindow(linearLayout.getApplicationWindowToken(),
                        InputMethodManager.SHOW_FORCED, 0);
            }
        });
    }

    KeyboardVisibilityEvent.setEventListener(
            AddActivity.this,
            new KeyboardVisibilityEventListener() {
                @Override
                public void onVisibilityChanged(boolean isOpen) {
                    // some code depending on keyboard visiblity status
                    Log.d(TAG, "Keyboard visibility changed");

                    int currentLine = getCurrentCursorLine(noteEditText);

                    lineCount = noteEditText.getLineCount();

                    if (isOpen && keyboardActuallyOpen) {
                        Log.d(TAG, "Keyboard is open");
                        //keyboardActuallyClosed = false;

                            /*
                            scrollView.fullScroll(View.FOCUS_UP);
                            noteEditText.requestFocus();
                            */

                        if (currentLine < 25) {

                            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

                            scrollView.scrollTo(0, 0);

                            noteEditText.setMinLines(12);
                            noteEditText.setLines(12);
                            noteEditText.setMaxLines(12);
                            scrollView.scrollTo(0, 0);

                            noteEditText.setVerticalScrollBarEnabled(true);
                            scrollView.setVerticalScrollBarEnabled(false);
                            noteEditText.setCursorVisible(true);

                            scrollView.requestLayout();
                            noteEditText.requestLayout();
                        } else {

                            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

                            scrollView.scrollTo(0, 0);
                            noteEditText.setMinLines(12);
                            noteEditText.setLines(12);
                            noteEditText.setMaxLines(12);
                            scrollView.scrollTo(0, 0);

                            noteEditText.setVerticalScrollBarEnabled(true);
                            scrollView.setVerticalScrollBarEnabled(false);
                            noteEditText.setCursorVisible(true);
                        }
                    } else {

                        if (!keyboardActuallyOpen) {


                            lineCount = noteEditText.getLineCount();

                            Log.d(TAG, "Keyboard is closed: " + lineCount);
                            noteEditText.setVerticalScrollBarEnabled(false);
                            scrollView.setVerticalScrollBarEnabled(true);
                            noteEditText.setCursorVisible(false);

                            noteEditText.setMinLines(lineCount);
                            noteEditText.setLines(lineCount);
                            noteEditText.setMaxLines(lineCount);
                            scrollView.scrollTo(0, 0);

                            keyboardActuallyOpen = false;

                            //scrollView.requestFocus();
                            //setAdjustResize(1);

                            LinearLayout mainLayout = (LinearLayout) findViewById(R.id.add_record);
                            if (mainLayout != null) {
                                mainLayout.requestFocus();
                            }
                        }

                    }
                }
            });

    noteEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            Log.d(TAG, "onFocusChange");

            if (firstStart) {
                scrollView.scrollTo(0, 0);
                noteEditText.setLines(12);
                noteEditText.setCursorVisible(true);
                firstStart = false;
            }

            if (hasFocus) {
                Log.d(TAG, "Has Focus");
                keyboardActuallyOpen = true;
            } else {
                Log.d(TAG, "Lost focus");
                keyboardActuallyOpen = false;
                setAdjustResize(2);
            }
        }
    });
    noteEditText.setOnKeyListener(new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
                Log.d(TAG, "closeKeyboard");

                keyboardActuallyOpen = false;

                noteEditText.setMinLines(lineCount);
                noteEditText.setLines(lineCount);
                noteEditText.setMaxLines(lineCount);

                noteEditText.setVerticalScrollBarEnabled(false);
                noteEditText.setCursorVisible(false);
                noteEditText.requestLayout();

                scrollView.scrollTo(0, 0);
                scrollView.setVerticalScrollBarEnabled(true);
                scrollView.requestLayout();

                noteEditText.clearFocus();
            }
            return false;
        }
    });


}