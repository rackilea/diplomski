ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View textView) {
            getFragmentManager().beginTransaction().replace(R.id.container, new LoginActivity() ).addToBackStack("").commit();
        }
    };