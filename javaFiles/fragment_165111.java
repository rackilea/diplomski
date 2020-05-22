public class YourFragment extends Fragment implements ODKortrijkWebservice.Callback, Adaptor.ItemCLickCallback {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle);
        ODKortrijkWebservice webs = new ODKortrijkWebservice(this.getActivity(), this);
        webs.execute();

        return view;
    }

    @Override
    public void onSuccess(ArrayList<Winkel> winkels) {
        Adaptor adaptor = new Adaptor(winkels, getContext());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addItemDecoration(new VerticalSpace(30));
        mRecyclerView.setAdapter(adaptor);
        adaptor.setItemCLickCallback(this);
    }

    @Override
    public void onItemClick(int p) {

    }

    @Override
    public void onSecItemClick(int p) {

    }
}