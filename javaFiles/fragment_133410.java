private void fadeOutView(View view) {
    Animation fadeOut = AnimationUtils.loadAnimation(view.getContext(), R.anim.fade_out);
    if (fadeOut != null) {
        fadeOut.setAnimationListener(new ViewAnimationListener(view) {
            @Override
            protected void onAnimationStart(View view, Animation animation) {

            }

            @Override
            protected void onAnimationEnd(View view, Animation animation) {
                view.setVisibility(View.GONE);
            }
        });
        view.startAnimation(fadeOut);
    }
}

private void fadeInView(View view) {
    Animation fadeIn = AnimationUtils.loadAnimation(view.getContext(), R.anim.fade_in);
    if (fadeIn != null) {
        fadeIn.setAnimationListener(new ViewAnimationListener(view) {
            @Override
            protected void onAnimationStart(View view, Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            protected void onAnimationEnd(View view, Animation animation) {

            }
        });
        view.startAnimation(fadeIn);
    }
}

private void slideInView(View view) {
    Animation slideIn = AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_in_right);
    if (slideIn != null) {
        slideIn.setAnimationListener(new ViewAnimationListener(view) {
            @Override
            protected void onAnimationStart(View view, Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            protected void onAnimationEnd(View view, Animation animation) {

            }
        });
        view.startAnimation(slideIn);
    }
}

private void slideOutView(View view) {
    Animation slideOut = AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_out_right);
    if (slideOut != null) {
        slideOut.setAnimationListener(new ViewAnimationListener(view) {
            @Override
            protected void onAnimationStart(View view, Animation animation) {

            }

            @Override
            protected void onAnimationEnd(View view, Animation animation) {
                view.setVisibility(View.GONE);
            }
        });
        view.startAnimation(slideOut);
    }
}

private abstract class ViewAnimationListener implements Animation.AnimationListener {

    private final View view;

    protected ViewAnimationListener(View view) {
        this.view = view;
    }

    @Override
    public void onAnimationStart(Animation animation) {
        onAnimationStart(this.view, animation);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        onAnimationEnd(this.view, animation);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    protected abstract void onAnimationStart(View view, Animation animation);
    protected abstract void onAnimationEnd(View view, Animation animation);
}