final StringBuilder text = new StringBuilder();

    tv.setOnTouchListener(new View.OnTouchListener(text) {
        private final StringBuilder text;

        private View.OnTouchListener(StringBuilder text) { // THIS IS NOT VALID SYNTAX, JUST DEMONSTRATING WHAT'S GOING ON BEHIND THE SCENES
           this.text = text;
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Log.d("findWordForRightHanded", text.toString());
            return false;
        }
    });