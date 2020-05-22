public void onFade1(View view) {
    image1 = (ImageView) findViewById(R.id.iv_img1);
    image2 = (ImageView) findViewById(R.id.iv_img2);

    image1.animate().alpha(0).setDuration(2000).setListener(new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            image1.setVisibility(View.GONE);
            System.out.println("image1 Gone");
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    });
    image2.animate().alpha(1).setDuration(2000).setListener(new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {
            image2.setVisibility(View.VISIBLE);
            System.out.println("image2 VISIBLE");
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
    System.out.println("Hi");
}

public void onFade2(View view) {
    image1 = (ImageView) findViewById(R.id.iv_img1);
    image2 = (ImageView) findViewById(R.id.iv_img2);

    image2.animate().alpha(0).setDuration(2000).setListener(new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            image2.setVisibility(View.GONE);
            System.out.println("image2 GONE");
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    });

    image1.animate().alpha(1).setDuration(2000).setListener(new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {
            image1.setVisibility(View.VISIBLE);
            System.out.println("image1 VISIBLE");
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
    System.out.println("Hello");
}