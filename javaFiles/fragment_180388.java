public class ExampleFragment extends Fragment implements MyAdapter.SuccessResponse{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView  = inflater.inflate(R.layout.my_layout, container, false);
        MyAdapter myAdapter = new MyAdapter(getActivity(), 0);
        myAdapter.successResponse = this;
        return contentView;
    }

    @Override
    public void onSuccess() {

    }
}