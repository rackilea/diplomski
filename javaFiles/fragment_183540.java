for (int i = 0; i < tw.getChildCount(); i++)
    {
        View v = tw.getChildAt(i);
        v.setBackgroundDrawable(null);
        v.setOnTouchListener(new OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {

                // Change the icon and background colors
                TabWidget tw = getTabWidget();
                for (int i = 0; i < tw.getChildCount(); i++)
                {
                    View vv = tw.getChildAt(i);
                    vv.setBackgroundDrawable(null);
                    vv.setId(0);
                }

                NonScalingBackgroundDrawable nsbd = new NonScalingBackgroundDrawable(getApplicationContext(), v, R.drawable.nav_highlight);

                v.setBackgroundDrawable(nsbd);

                v.setId(1);
                return false;

            }

        });
    }
}