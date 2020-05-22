ViewTreeObserver viewTreeObserver  = mWebView.getViewTreeObserver();

viewTreeObserver.addOnPreDrawListener(new OnPreDrawListener() {
                   @Override
                   public boolean onPreDraw() {                                
                           int height = mWebView.getMeasuredHeight();
                           if( height != 0 ){
                                   Toast.makeText(getActivity(), "height:"+height,Toast.LENGTH_SHORT).show();
                                   mWebView.getViewTreeObserver().removeOnPreDrawListener(this);
                           }
                           return false;
                   }
           });