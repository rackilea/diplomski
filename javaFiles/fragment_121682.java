public class FragmentMyList
        extends Fragment {
    private RecyclerView recyclerView;
    private EditText editTxt;
    private FloatingActionButton btn;

    private AdapterItemsRecycler adapterItemsRecycler;

    private Realm realm;

    RealmResults<Item> results;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vistaADevolver = inflater.inflate(R.layout.fragment_my_list, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        Realm.init(getContext());
        realm = Realm.getDefaultInstance();

        editTxt = (EditText) vistaADevolver.findViewById(R.id.editText);
        btn = (FloatingActionButton) vistaADevolver.findViewById(R.id.button);
        recyclerView = (RecyclerView) vistaADevolver.findViewById(R.id.recyclerViewToDo);

        results = realm.where(Item.class).equalTo("id", 1).findAll();
        final InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

        adapterItemsRecycler = new AdapterItemsRecycler(results, new ItemsListener());
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new SimpleItemDivider(getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapterItemsRecycler);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemName = editTxt.getText().toString();
                saveIntoDatabase(itemName);

                inputManager.hideSoftInputFromWindow(getView().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                editTxt.getText().clear();
            }
        });
        return vistaADevolver;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    private void saveIntoDatabase(final String itemName) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                Item item = bgRealm.createObject(Item.class);
                item.setName(itemName);
                item.setPoint(itemName);
                item.setId(1);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // Transaction was a success.
                Log.v("database", "Stored ok");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
                Log.e("database", error.getMessage());
            }
        });

    }

    class ItemsListener
            implements AdapterView.OnClickListener {
        @Override
        public void onClick(View view) {
            Item itemTouched = results.get(recyclerView.getChildAdapterPosition(view));
            EscuchadorInterface unEscuchador = (EscuchadorInterface) getActivity();
            unEscuchador.itemSelected(itemTouched);
        }
    }

    public interface EscuchadorInterface {
        public void itemSelected(Item anItem);
    }
}