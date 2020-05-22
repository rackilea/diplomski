refresh.setOnTouchListener(new View.OnTouchListener() {
        /**
         * Called when a touch event is dispatched to a view. This allows listeners to
         * get a chance to respond before the target view.
         *
         * @param v     The view the touch event has been dispatched to.
         * @param event The MotionEvent object containing full information about
         *              the event.
         * @return True if the listener has consumed the event, false otherwise.
         */
        @Override
        public boolean onTouch(View v, MotionEvent event) {
           Toast toast = Toast.makeText(getActivity().getApplicationContext(), "TEST", Toast.LENGTH_LONG);
           toast.show();             
           return false;
        }
    });