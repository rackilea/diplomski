myWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                myProgressBar.setProgress(newProgress);

                if (newProgress == 100) {
                    AlphaAnimation fadeOut;
                    fadeOut = new AlphaAnimation(1, 0);
                    fadeOut.setDuration(500);
                    fadeOut.setFillAfter(true);
                    fadeOut.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            // whatever you want to happen when the fadeOut animation starts
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            // whatever you want to happen when the fadeOut animation ends
                            myProgressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                            // whatever you want to happen when the fadeOut animation repeats itself
                        }
                    });
                    myProgressBar.startAnimation(fadeOut);
                } else {
                    myProgressBar.setVisibility(View.VISIBLE);
                }
            }
        });