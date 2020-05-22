beispiel.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                beispiel.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                beispiel.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }

            int width = beispiel.getWidth();
            for(int i = 0; i <= 20; i++){
                // make the height and width of each ImageView equal to width of beispiel
                profilbilder[i].setLayoutParams(new LinearLayout.LayoutParams(width, width));
            }
        }
    });