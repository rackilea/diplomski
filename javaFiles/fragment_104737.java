if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                    WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
    (your view)view.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }