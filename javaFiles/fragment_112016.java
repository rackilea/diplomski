public abstract class PageFragment extends Fragment {

protected Boolean mVisibleToUserFlag = null;

@Override
public void onResume() {
    super.onResume();

    if (mVisibleToUserFlag != null && mVisibleToUserFlag) {
        onVisible();
    }
}

@Override
public void setUserVisibleHint(boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);

    if (isVisibleToUser && (mVisibleToUserFlag == null || mVisibleToUserFlag == false)) {
        mVisibleToUserFlag = true;
        if (isResumed()) {
            onVisible();
        }
    } else if (!isVisibleToUser && mVisibleToUserFlag == null) {
        mVisibleToUserFlag = false;
    } else if (!isVisibleToUser && mVisibleToUserFlag) {
        onHide();
        mVisibleToUserFlag = false;
    }
}

@Override
public void onDestroyView() {
    super.onDestroyView();

    mVisibleToUserFlag = null;
}

/**
 * This method invoked when page stand visible to user.
 */
public abstract void onVisible();

/**
 * This method invoked then page change state visibility change to hidden.
 */
public abstract void onHide();