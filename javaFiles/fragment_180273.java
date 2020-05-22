popupWindow.showAtLocation(popupLayout, Gravity.CENTER, 0, 0);

    (***)

    //Start PopUp
    popupContext = getApplicationContext();
    popupActivity =  MainActivity.this;
    LayoutInflater inflater = (LayoutInflater) popupContext.getSystemService(LAYOUT_INFLATER_SERVICE);
    View popupView = inflater.inflate(R.layout.activity_start, null);
    popupWindow = new PopupWindow(popupView,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT);
    if (Build.VERSION.SDK_INT >= 21){
        popupWindow.setElevation(5.0f);
    }