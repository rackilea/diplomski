wmlp.flags = WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
wmlp.flags &= ~(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
wmlp.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT |  WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
wmlp.format = -1;
wmlp.token = null;
wmlp.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE;