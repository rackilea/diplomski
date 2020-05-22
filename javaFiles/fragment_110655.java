public interface OnAnimationEnd {
    void onAnimationEnd(Animation animation);
}

public interface OnAnimationStart {
    void onAnimationStart(Animation animation);
}

public class AnimationListeners {
    public static Animation.AnimationListener adapt(OnAnimationStart oas) {
        return new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                oas.onAnimationStart(animation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    // same for the end
}