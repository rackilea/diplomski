FlutterView.FirstFrameListener mListener = new FlutterView.FirstFrameListener() {
      @Override
      public void onFirstFrame() {
        getFlutterView().pushRoute("/alarm");
      }
    };

    getFlutterView().addFirstFrameListener(mListener);