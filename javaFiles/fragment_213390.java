public class SecurityListFragment extends BaseFragment {

private TestAdapter mTestAdapter;
private SecurityResponse securityResponse;
private FetchDataInterface dataInterface;
private ListView lista;//**changed**

public SecurityListFragment() {
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    Log.v("ListFragment", "I entered the onCreateView!");

    final View root = inflater.inflate(R.layout.security_listview_fragment, container, false);
    Log.v("ListFragment", "rootView created");


    //set adapter
    lista = (ListView) root.findViewById(R.id.listview_security);//**changed**

    Log.v("dasd", "asdasdasd");//for breakpoint usage
    return root;
}

@Override
public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    dataInterface = RetrofitUtils.createGsonRetrofitInterface();
    RetrofitUtils.testGetPspDataFromApi(new Callback<SecurityResponse>() {
        @Override
        public void onResponse(Call<SecurityResponse> call, Response<SecurityResponse> response) {
            if (response.isSuccessful()) {
                securityResponse = response.body();
                mTestAdapter = new TestAdapter(getActivity(), R.layout.list_security_row_item, securityResponse.features);
              lista.setAdapter(mTestAdapter);//**changed**
                Log.v("ListFragment", "great success");



            }
        }

        @Override
        public void onFailure(Call<SecurityResponse> call, Throwable t) {

        }
    }, dataInterface);
    Log.v("adasdadsa","asdasdasdasdasasdas");//more breakpoint usage
}