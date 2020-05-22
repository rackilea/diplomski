public abstract class ObservableFragmentPagerAdapter extends FragmentPagerAdapter {

    private Fragment mCurrentFragment = null;
    private OnPrimaryItemChangedListener mPrimaryItemListener = null;

    public ObservableFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);

        if (mCurrentFragment != object) {
            Fragment newFragment = (Fragment) object;
            if (mPrimaryItemListener != null) {
                mPrimaryItemListener.onPrimaryItemChanged(mCurrentFragment, newFragment);
            }
            mCurrentFragment = newFragment;
        }
    }

    public void setOnPrimaryItemChangedListener(OnPrimaryItemChangedListener listener) {
        mPrimaryItemListener = listener;
    }

    public interface OnPrimaryItemChangedListener {
        void onPrimaryItemChanged(Fragment oldFragment, Fragment newFragment);
    }
}