/**
 * Called to have the fragment instantiate its user interface view.
 * This is optional, and non-graphical fragments can return null (which
 * is the default implementation).  This will be called between
 * {@link #onCreate(Bundle)} and {@link #onActivityCreated(Bundle)}.
 *
 * <p>If you return a View from here, you will later be called in
 * {@link #onDestroyView} when the view is being released.
 *
 * @param inflater The LayoutInflater object that can be used to inflate
 * any views in the fragment,
 * @param container If non-null, this is the parent view that the fragment's
 * UI should be attached to.  The fragment should not add the view itself,
 * but this can be used to generate the LayoutParams of the view.
 * @param savedInstanceState If non-null, this fragment is being re-constructed
 * from a previous saved state as given here.
 *
 * @return Return the View for the fragment's UI, or null.
 */
@Nullable
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)