private void stepRecursive(final boolean isLeftFoot,final int mInterval) {
    mHandler.postDelayed(new Runnable() {

        @Override
        public void run() {
            if (isLeftFoot) {
                mLeftfoot.startAnimation(mFootAnim);
            } else {
                mRightfoot.startAnimation(mFootAnim);
            }
            if (!pleaseStop)
                stepRecursive(isLeftFoot,mInterval);
        }
    }, mInterval);
}