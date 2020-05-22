public class ChildFragment extends Fragment {
    private TextView mTextView;
    private boolean mIsTextVisible;

    public static ChildFragment newInstance() {
        Bundle args = new Bundle();
        ChildFragment fragment = new ChildFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child, container, false);
        mTextView = (TextView) view.findViewById(R.id.make_this_text_visible);
        setTextVisible(mIsTextVisible);

        return view;
    }

    public void setTextVisible(boolean isVisible) {
        mIsTextVisible = isVisible;
        if(mTextView != null) {
            mTextView.setVisibility(isVisible ? View.VISIBLE : View.GONE);
        }
    }
}