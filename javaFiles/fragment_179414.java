public class TransactionHistoryFragment extends Fragment implements SearchView.OnQueryTextListener,
        DateRangePickerFragment.OnDateRangeSelectedListener, SearchMobileFragment.OnMobileNumberSelectedListener{

    private RecyclerView recyclerview;
    private TransactionHistoryAdapter adapter;
    private List<Transaction> transactionList;

    SearchView search;

    public static final String TIMERANGEPICKER_TAG = "timerangepicker";



    public TransactionHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_transaction_history, container, false);

        recyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);
        getTransactionHistory();
    }

    @Override
    public void onResume() {
        Log.e("onResumeTHF","invoked");
        super.onResume();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.transactions_history_menu, menu);
        search = (SearchView) menu.findItem(R.id.action_search).getActionView();
        search.setOnQueryTextListener(this);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.filter_date:
                FragmentManager fmDate = getActivity().getFragmentManager();
                DateRangePickerFragment dialogFragmentDate = DateRangePickerFragment.newInstance(this, true);
                dialogFragmentDate.show(fmDate, "Sample Fragment");
                return true;
            case R.id.filter_mobile:
                FragmentManager fmMobile = getActivity().getFragmentManager();
                SearchMobileFragment dialogFragmentMobile = SearchMobileFragment.newInstance(this);
                dialogFragmentMobile.show(fmMobile, "Sample Fragment");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("newText",newText);
       final List<Transaction> filteredModelList = filter(transactionList, newText);

        adapter.setFilter(filteredModelList);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }




    @Override
    public void onMobileNumberSelected(String mobileNumber) {

        Log.e("mobileNumber",mobileNumber);

        resetAdapterDetails();
    }


    public boolean resetAdapterDetails(){
        try {
            transactionList.clear();
            adapter.notifyDataSetChanged();
            recyclerview.setAdapter(adapter);

        } catch (Exception e) {
            Log.e("Reset Error", ""+e.getMessage());
        }

        return true;
    }
}