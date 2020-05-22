final TextView textView = yourTextView;
    final int[] array = {R.string.text1, R.string.text2,R.string.text3,R.string.text4,R.string.text5};
    textView.post(new Runnable() {
        int i = 0;
        @Override
        public void run() {
            textView.setText(array[i]);
            i++;
            if (i ==5)
                i = 0;
            textView.postDelayed(this, 5000);
        }
    });