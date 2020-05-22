public static class MyFragment extends Fragment {

        @Override
        public void onResume() {
            super.onResume();
            getView().setFocusableInTouchMode(true);
            getView().requestFocus();
            getView().setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    //YOUR CODE
                    return false;
                }
            });
        }
    }