/**
 * Add a fragment to the activity state.  This fragment may optionally
 * also have its view (if {@link Fragment#onCreateView Fragment.onCreateView}
 * returns non-null) inserted into a container view of the activity.
 *
 * @param containerViewId Optional identifier of the container this fragment is
 * to be placed in.  If 0, it will not be placed in a container.
 * @param fragment The fragment to be added.  This fragment must not already
 * be added to the activity.
 * @param tag Optional tag name for the fragment, to later retrieve the
 * fragment with {@link FragmentManager#findFragmentByTag(String)
 * FragmentManager.findFragmentByTag(String)}.
 *
 * @return Returns the same FragmentTransaction instance.
 */
public abstract FragmentTransaction add(@IdRes int containerViewId, Fragment fragment, String tag);