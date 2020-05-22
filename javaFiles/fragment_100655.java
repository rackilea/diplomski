public class AccountContents extends Fragment {
private AccountItem[] rootContents;
private ListView ls1;
private CArrayAdapter adapter;
private Context context;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {

    final View V = inflater.inflate(R.layout.account_contents, container,
    false);
    context = V.getContext();
    rootContents = fourshared.rootContents;
    adapter = new CArrayAdapter(context, rootContents);
    ls1 = (ListView) V.findViewById(R.id.AC_listView);
    ls1.setAdapter(adapter);
    ls1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, final View view,
            int position, long id) {

            View toolbar = view.findViewById(R.id.toolbar);
            ExpandAnimation expandAni = new ExpandAnimation(toolbar, 500);
            toolbar.startAnimation(expandAni);
        }
    });
    return V;
    }
}