WindowManager manager = ((WindowManager) getApplicationContext()
            .getSystemService(Context.WINDOW_SERVICE));

WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
localLayoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
localLayoutParams.gravity = Gravity.TOP;
localLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|

            // this is to enable the notification to recieve touch events
            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |

            // Draws over status bar
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;

    localLayoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
    localLayoutParams.height = (int) (50 * getResources()
            .getDisplayMetrics().scaledDensity);
    localLayoutParams.format = PixelFormat.TRANSPARENT;

    customViewGroup view = new customViewGroup(this);

    manager.addView(view, localLayoutParams);