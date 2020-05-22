public class HostFragment extends BackStackFragment {
    private Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.host_fragment, container, false);
        if (fragment != null) {
            replaceFragment(fragment, false);
        }
        return view;
    }

    public void replaceFragment(Fragment fragment, boolean addToBackstack) {
        if (addToBackstack) {
            getChildFragmentManager().beginTransaction().replace(R.id.hosted_fragment, fragment).addToBackStack(null).commit();
        } else {
            getChildFragmentManager().beginTransaction().replace(R.id.hosted_fragment, fragment).commit();
        }
    }

    public static HostFragment newInstance(Fragment fragment) {
        HostFragment hostFragment = new HostFragment();
        hostFragment.fragment = fragment;
        return hostFragment;
    }
}