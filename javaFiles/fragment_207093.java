//Set tabs to take up entire screen width
    WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    Display display = wm.getDefaultDisplay();
    Point size = new Point();
    if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB_MR2) {
        display.getSize(size);
    }
    else
    {
        size.set(display.getWidth(), display.getHeight());
    }
    textView.setWidth(size.x / 2);