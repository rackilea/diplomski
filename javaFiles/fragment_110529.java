int sec = 0;
case R.id.buttonRandom:
    final Handler h = new Handler();
    h.postDelayed(new Runnable() {
        @Override
        public void run() {
            if (sec % 10 >= 0 && sec % 10 < 6) {
                mTextView.setText(R.string.buttonGreen);
                mRelativeLayout.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            } else if (sec % 10 >= 6 && sec % 10 < 7) {
                mTextView.setText(R.string.buttonYellow);
                mRelativeLayout.setBackgroundColor(getResources().getColor(R.color.colorYellow));
            } else if (sec % 10 >= 7 && sec % 10 < 9) {
                mTextView.setText(R.string.buttonRed);
                mRelativeLayout.setBackgroundColor(getResources().getColor(R.color.colorRed));
            }

            sec++;
            if (sec < 11) {
                h.postDelayed(this);
            }
        }
    }, 1000);