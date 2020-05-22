public class MyFragment extends Fragment {

    private GridLayoutManager lLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    // onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container, false);

        // Get screen size to have different layouts for phone and tablet
        int screenSize = getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK;

        String toastMsg;
        switch (screenSize) {
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
                toastMsg = "Large screen";
                Log.d("tag_name", "Large screen");
                break;
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                toastMsg = "Normal screen";
                Log.d("tag_name", "Normal screen");
                break;
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
                toastMsg = "Small screen";
                Log.d("tag_name", "Small screen");
                break;
            default:
                toastMsg = "Screen size is neither large, normal or small";
                Log.d("tag_name", "Screen size is not large, normal, or small");
        }
        Toast.makeText(getActivity(), toastMsg, Toast.LENGTH_LONG).show();

        // Create an empty list to initialize the adapter (or else get nullPointerException error)

        // 3 rows for tablet
        // 2 rows for phone

        if (screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE
                || screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
            lLayout = new GridLayoutManager(getActivity(), 3, GridLayoutManager.HORIZONTAL, false);
        } else
            lLayout = new GridLayoutManager(getActivity(), 2, GridLayoutManager.HORIZONTAL, false);

        RecyclerView rView = (RecyclerView) view.findViewById(R.id.recycler_view);

        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        rView.setAdapter(rcAdapter);

        return view;
    }

    RecyclerViewAdapter rcAdapter;

    private List<ItemObject> getAllItemList(String applicationName, Drawable app_drawable) {

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject(applicationName, app_drawable));

        return allItems;
    }

    public void createButton(Drawable d, String appName) {

        rcAdapter.addItem(new ItemObject(appName , d))

    }

}