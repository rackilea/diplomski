mWebview.setOnKeyListener(new View.OnKeyListener(){

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK
                        && event.getAction() == MotionEvent.ACTION_UP
                        && mWebview.canGoBack())
                {
                    mWebview.goBack();
                    return true;
                }
                return false;
            }

        });