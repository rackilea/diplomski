public abstract class BaseFragment extends Fragment {

protected Activity mActivity;

/**
 * isFragmentVisible
 */
private boolean isFragmentVisible;
/**
 * View in onCreateView is ok
 */
private boolean isPrepared;
/**
 * isFirstLoad
 */
private boolean isFirstLoad = true;
/**
 * isForceLoad
 */
private boolean isForceLoad = false;


/**
 * onAttach Activity
 *
 * @param context
 */
@Override
public void onAttach(Context context) {
    super.onAttach(context);
    this.mActivity = (Activity) context;
}


@Nullable
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container
        , Bundle savedInstanceState) {

    isFirstLoad = true;
    View view = LayoutInflater.from(mActivity)
            .inflate(getLayoutId(), container, false);
    initView(view, savedInstanceState);
    isPrepared = true;
    lazyLoad();

    return view;
}

@Override
public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
}

@Override
public void onDestroy() {
    super.onDestroy();
}


/**
 * want to load data ,need set in onCreateView
 * isPrepared = true;
 */
protected void lazyLoad() {
    if (isPrepared() && isFragmentVisible()) {
        if (isForceLoad || isFirstLoad()) {
            isForceLoad = false;
            isFirstLoad = false;
            initData();
        }
    }
}

public boolean isPrepared() {
    return isPrepared;
}

public boolean isFirstLoad() {
    return isFirstLoad;
}

public boolean isFragmentVisible() {
    return isFragmentVisible;
}

/**
 * use with viewpager
 *
 * @param isVisibleToUser is visible for user
 */
@Override
public void setUserVisibleHint(boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);
    if (getUserVisibleHint()) {
        onVisible();
    } else {
        onInvisible();
    }
}

/**
 * if you use show hide to set fragment ,do this
 *
 * @param hidden hidden True if the fragment is now hidden, false if it is not
 *               visible.
 */
@Override
public void onHiddenChanged(boolean hidden) {
    super.onHiddenChanged(hidden);
    if (!hidden) {
        onVisible();
    } else {
        onInvisible();
    }
}

protected void onVisible() {
    isFragmentVisible = true;
    lazyLoad();
}

protected void onInvisible() {
    isFragmentVisible = false;
}

/**
 * set force load
 */
public void setForceLoad(boolean forceLoad) {
    this.isForceLoad = forceLoad;
}


/**
 * getLayoutId ,like : R.layout.fragment
 *
 * @return
 */
protected abstract int getLayoutId();

/**
 * initView
 *
 * @param view
 * @param savedInstanceState
 */
protected abstract void initView(View view, Bundle savedInstanceState);

/**
 * load data here
 */
protected abstract void initData();

}