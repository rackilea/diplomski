public class ContainerFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_container, container, false);
        getChildFragmentManager().beginTransaction().replace(R.id.fragment_container_root_view, new TestFragment()).commit();
        return view;
    }
}