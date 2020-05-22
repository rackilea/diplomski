@Override
public View onCreateView(String name, Context context, AttributeSet attrs)  {
    // Do you own inflater stuff here 
    // Check for menu items (Options menu AKA menu key) 
    if (name.equalsIgnoreCase("android.support.v7.view.menu.ListMenuItemView")) {
        try { 
            // Ask our inflater to create the view 
            final View view = LayoutInflater.from(context).createView(name, null, attrs); 
            // Kind of apply our own background 
            new Handler().post(new Runnable() {
                public void run() {
                    if (!Common.compatible(Common.color, 0xFF000000)) {
                        try {
                            ((TextView)((RelativeLayout)((ListMenuItemView)view).getChildAt(1)).getChildAt(0)).setTextColor(0xFFFFFFFF);
                        } catch (ClassCastException e) {

                        }
                    } else {
                        try {
                            ((TextView)((RelativeLayout)((ListMenuItemView)view).getChildAt(1)).getChildAt(0)).setTextColor(0xFF000000);
                        } catch (ClassCastException e) {

                        }
                    }
                    view.setBackgroundColor(Common.color);
                }
            });
            return view;
        } catch (InflateException e) {

        } catch (ClassNotFoundException e) {

        }
    }
    return null; 
}