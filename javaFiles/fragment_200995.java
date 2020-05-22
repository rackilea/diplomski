public void ting(final Context mContext, final String msg) {

            ((Activity)mContext).runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    Toast myToast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
                    myToast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
                    TextView tv = (TextView) myToast.getView().findViewById(android.R.id.message);
                    tv.setTextColor(Color.parseColor(configurationz.COLORS_TOAST_TEXT_COLOR));
                    tv.setTextSize(20);
                    myToast.getView().setBackgroundColor(Color.parseColor(configurationz.COLORS_TOAST_BACKGROUND));
                    myToast.show();
                }
            });

        }