private void performSwipeAction(final View swipeView, final int swipePosition, boolean toTheRight, boolean dismiss) {
            // Animate the dismissed list item to zero-height and fire the dismiss callback when
            // all dismissed list item animations have completed. This triggers layout on each animation
            // frame; in the future we may want to do something smarter and more performant.

            final ViewGroup.LayoutParams lp = swipeView.getLayoutParams();
            final int originalHeight = swipeView.getHeight();
            final boolean swipeRight = toTheRight;

            ValueAnimator animator;
            if (dismiss)
                animator = ValueAnimator.ofInt(originalHeight, 1).setDuration(mAnimationTime);
            else
                animator = ValueAnimator.ofInt(originalHeight, originalHeight - 1).setDuration(mAnimationTime);


            animator.addListener(new AnimatorListenerAdapter() {
                @
                        Override
                public void onAnimationEnd(Animator animation) {
                    --mDismissAnimationRefCount;
                    if (mDismissAnimationRefCount == 0) {
                        // No active animations, process all pending dismisses.
                        // Sort by descending position
                        Collections.sort(mPendingSwipes);

                        int[] swipePositions = new int[mPendingSwipes.size()];
                        for (int i = mPendingSwipes.size() - 1; i >= 0; i--) {
                            swipePositions[i] = mPendingSwipes.get(i).position;
                        }
                        if (swipeRight) {
                            mCallback.onSwipeRight(mListView, swipePositions);
                            Log.d("SAMPLE", "SAMPLE IN SWIPE -- " + swipePosition);
                        }else {
Log.d("SAMPLE", "SAMPLE IN SWIPE -- " + swipePosition);
                            mCallback.onSwipeLeft(mListView, swipePositions);
                        }
                        ViewGroup.LayoutParams lp;
                        for (PendingSwipeData pendingDismiss : mPendingSwipes) {
                            // Reset view presentation
                            pendingDismiss.view.setAlpha(1f);
                            pendingDismiss.view.setTranslationX(0);
                            lp = pendingDismiss.view.getLayoutParams();
                            lp.height = originalHeight;
                            pendingDismiss.view.setLayoutParams(lp);
                        }

                        mPendingSwipes.clear();
                    }
                }
            });