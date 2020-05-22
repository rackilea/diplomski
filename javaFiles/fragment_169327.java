new Handler().postDelayed(new Runnable() {
     @Override
     public void run() {
        final String s = getGiphyViews(String.valueOf(mEdit.getText()));
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                result.setText(s);
            }
        });

        loading.animate()
                .alpha(0)
                .setDuration(100);

        done.animate()
                .scaleY(1)
                .scaleX(1)
                .setDuration(300);
     }
}, 100);