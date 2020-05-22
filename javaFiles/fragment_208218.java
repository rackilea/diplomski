setContentView(R.layout.activity_web_view);
...

mWebview = (FlingView) findViewById(R.id.webview);

mWebview.setFlingListener(new FlingView.FlingListener() {
        @Override
        public void onLeftFling() {
            Log.d(TAG, ACTIVITY_TAG + "onFling left: ");
            someDynamicObject.thatCantBeUsedStatically();
        }

        @Override
        public void onRightFling() {
            Log.d(TAG, ACTIVITY_TAG + "onFling right: ");
            anotherDynamicObject.thatCantBeUsedStatically();
        }
    }
);