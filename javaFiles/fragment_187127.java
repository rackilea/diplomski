private void setTextWithSmoothAnimation(TextView textView, String message) {
        textView.animate().setDuration(300).setListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {

            }


            @Override
            public void onAnimationEnd(Animator animation) {
                textView.setText(message);
                textView.animate().setListener(null).setDuration(300).alpha(1);
            }


            @Override
            public void onAnimationCancel(Animator animation) {

            }


            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).alpha(0);
    }