@TargetApi(11)
public class NewVersionLoader extends VersionedLoader {
    private class Foo implements AnimatorListener {
        @Override
        public void onAnimationStart(Animator animation) {}

        @Override
        public void onAnimationEnd(Animator animation) {}

        @Override
        public void onAnimationCancel(Animator animation) {}

        @Override
        public void onAnimationRepeat(Animator animation) {}

    }
}