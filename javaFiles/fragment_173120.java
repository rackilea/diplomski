public final class FadeHelper {
    public static void fade(final View view, Animator.AnimatorListener listener) {
        if (view.getVisibility() == View.VISIBLE) {

            // Create a composite listener and override onAnimationEnd()
            // to do your own thing, then call through to super to pass
            // the event to the provided listener.
            final Animator.AnimatorListener compositeListener = new CompositeAnimatorListenerAdapter(listener) {
                @Override
                public void onAnimationEnd(Animator animator) {
                    view.setAlpha(1f);
                    view.setVisibility(View.INVISIBLE);

                    // Not sure why this line is necessary?
                    view.animate().setListener(null);

                    // This passes the event to the original listener
                    super.onAnimationEnd(animator);
                }
            });

            view.animate()
                .setDuration(DURATION)
                .alpha(0f)
                .setListener(compositeListener);
        }
    }

    private static class CompositeAnimatorListenerAdapter implements Animator.AnimatorListener {
        private final Animator.AnimatorListener mDelegate;

        public CompositeAnimatorListenerAdapter(Animator.AnimatorListener delegate) {
            mDelegate = delegate;
        }

        @Override
        public void onAnimationStart(Animator animator) {
            if (mDelegate != null) {
                mDelegate.onAnimationStart(animator);
            }
        }

        @Override
        public void onAnimationEnd(Animator animator) {
            if (mDelegate != null) {
                mDelegate.onAnimationEnd(animator);
            }
        }

        @Override
        public void onAnimationCancel(Animator animator) {
            if (mDelegate != null) {
                mDelegate.onAnimationCancel(animator);
            }
        }

        @Override
        public void onAnimationRepeat(Animator animator) {
            if (mDelegate != null) {
                mDelegate.onAnimationRepeat(animator);
            }
        }
    }
}