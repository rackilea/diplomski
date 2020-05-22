// Called by the fragment manager once this fragment has been removed,
 // so that we don't have any left-over state if the application decides
 // to re-use the instance.  This only clears state that the framework
 // internally manages, not things the application sets.

void initState() {
    mIndex = -1;
    mWho = null;
    mAdded = false;
    mRemoving = false;
    mResumed = false;
    mFromLayout = false;
    mInLayout = false;
    mRestored = false;
    mBackStackNesting = 0;
    mFragmentManager = null;
    mActivity = null;
    mFragmentId = 0;
    mContainerId = 0;
    mTag = null;
    mHidden = false;
    mDetached = false;
    mRetaining = false;
    mLoaderManager = null;
    mLoadersStarted = false;
    mCheckedForLoaderManager = false;
}