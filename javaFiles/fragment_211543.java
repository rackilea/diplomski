public Emitter.Listener onTouchEvent = new Emitter.Listener() {
    @Override
    public void call(final Object... args) {
        ((Activity)getContext()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //Code for the UiThread
                JSONObject data = (JSONObject) args[0];
                String x = null;
                String y = null;
                String deviceId = data.getString("DeviceID");
                try {
                    x = data.getString("touchX");
                    y = data.getString("touchY");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.v("Touch", x+", "+y);
                float touchX = Float.parseFloat(x);
                float touchY = Float.parseFloat(y);

                map.get(deviceId).moveTo(touchX + 200, touchY + 200);
                invalidate();
            }
        });
    }
};