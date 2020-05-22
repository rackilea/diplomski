public class ChildFragment extends Fragment {
    public interface OnViewCreatedListener {
        void onViewCreated();
    }

    public View onCreateView(LayoutInflater inflater,
        @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_child, container, false);
        mTextView = (TextView) view.findViewById(R.id.make_this_text_visible);

        if(getParentFragment() instanceof OnViewCreatedListener) {
            ((OnViewCreatedListener) getParentFragment()).onViewCreated();
        } else if (getActivity() instanceof OnViewCreatedListener) {
            ((OnViewCreatedListener) getActivity()).onViewCreated();
        }

        return view;
    }
}