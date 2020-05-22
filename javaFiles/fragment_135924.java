public class PopularWrapperFragment extends Fragment {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    public static PopularWrapperFragment newInstance() {
        return new PopularWrapperFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular_holder, container, false);
        ButterKnife.bind(this, view);
        ((MainActivity) getActivity()).setPagingEnabled(false);
        viewPager.setAdapter(new PopularFragmentsAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}