// The View you're making the popup in regards to.
    View parent = findViewById(R.id....);

    View popupView = LayoutInflater.from(this).inflate(R.layout.activity_start, null);
    popupWindow = new PopupWindow(popupView,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT);

    if (Build.VERSION.SDK_INT >= 21){
        popupWindow.setElevation(5.0f);
    }
    popupWindow.showAtLocation(parent, Gravity.CENTER, 0, 0);