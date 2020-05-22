getActivity().runOnUiThread(new Runnable() {
        @Override
        public void run() {
            ((TextView) findViewById(R.id.txtFieldName)).setText("your text");
        }
    });