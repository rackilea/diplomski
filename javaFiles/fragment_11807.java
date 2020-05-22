final ValueAnimator timern = ValueAnimator.ofInt(secondsToRun);

public void nezablokovat() {
    int secondsToRun = 9999999;

    timern.setDuration(secondsToRun * 1000).setInterpolator(new LinearInterpolator());
    timern.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        int elapsedSeconds = (int) animation.getAnimatedValue();
        int minutes = elapsedSeconds / 60;
        int seconds = elapsedSeconds % 60;

        if (seconds%10 == 1) {
            Pis("$$$");
        }


    }

    });
    timern.start();
}

void teplotahore() {
    STup.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timern.cancel();
            }
        }

    });
}