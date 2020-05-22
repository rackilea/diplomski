private static long lastCharacterPress = 0l;
private Editable stringToSearchFor;
private Handler delayedCharacterCheck;

    edittext.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            lastCharacterPress = System.currentTimeMillis();
            stringToSearchFor = s;

            if (s.length() > 2) {

                delayedCharacterCheck.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        checkIfTimeHasPassed();
                    }
                }, 500);

            } else ...

        }
    });