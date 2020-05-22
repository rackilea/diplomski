final int newHeight    = (int) ((height / 380.0) * webView.getWidth());

    // Must set visible before setting layout params
    currentOldView.setVisibility(View.VISIBLE);

    // Without this line, view will bounce around as it attempts to self set the height based on HTML content
    currentOldView.setLayoutParams(new LinearLayout.LayoutParams(webView.getWidth(), newHeight));

    // Use viewTreeObserver to wait until scrollView completely laid out before attempting to scroll
    ViewTreeObserver observer = scrollView.getViewTreeObserver();
    observer.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            scrollView.scrollTo(0, newHeight);  // Because spinner_wrapper still on view, will scroll to an overlap point.
            canAddOldChat = true;
            currentOldView.startAnimation(fadeInAnim);

            if (isLastOldChat) spinner_wrapper.setAlpha(0.0f);

            scrollView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    });