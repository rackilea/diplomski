public void startCircularReveal() {
    final View view = findViewById(R.id.linearLayout);
    final View startView = findViewById(R.id.button_container);
    int cx = (startView.getLeft() + startView.getRight()) / 2;
    int cy = (startView.getTop() + startView.getBottom()) / 2;
    view.setBackgroundColor(Color.parseColor("#6FA6FF"));
    int finalRadius = Math.max(cy , view.getHeight() - cy);
    Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0, finalRadius);
    anim.addListener(new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {

        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    });
    anim.setDuration(200);
    view.setVisibility(View.VISIBLE);
    anim.start();
}