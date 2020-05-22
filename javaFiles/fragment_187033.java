public class AdjustMediaHeight extends AsyncTask<Void, Void, Void> {
    private View ll_food_media;
    private int videoHeight;
    private final int startHeight;
    private final int difference;

    public AdjustMediaHeight(View view, int height) {
        this.ll_food_media = view;
        this.videoHeight = height;
        this.startHeight = ll_food_media.getMeasuredHeight();
        this.difference = ll_food_media.getMeasuredHeight() - videoHeight;
    }

    @Override
    protected Void doInBackground(Void... params) {
        float i = 1;
        long lastMilli = System.currentTimeMillis();

        while (i < 60) {
            // closest frame rate compared to 33,33333333333
            // 33 comes from 30 / 1000
            if (System.currentTimeMillis() - lastMilli < 16)
                continue;

            final int newHeight = (int) (startHeight - (difference / 60 * i));

            APP.mOrderActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    ll_food_media.setLayoutParams(
                            new RelativeLayout.LayoutParams(
                                    800,
                                    newHeight
                            )
                    );

                    ll_food_media.requestLayout();
                }
            });

            Log.i("ANIMATION", "Frame #" + i + " completed. Height: " + newHeight);
            i++;
            lastMilli = System.currentTimeMillis();
        }


        return null;
    }
}