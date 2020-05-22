// new class level members
private ImageView mDrawerImage;
private TextView mDrawerText;

// change the View inflation and extract the new child views
// also modifying the ListView to now be a child instead of the root View
@Override
public View onCreateView(LayoutInflater inflater,
                         ViewGroup container,
                         Bundle savedInstanceState)
{
    // need site names for list
    siteNames = getActivity().getResources().getStringArray(R.array.site_names);
    Log.d(TAG, "number of sites loaded: " + siteNames.length);

    // inflate the parent view (the entire layout)
    View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
    // now grab the separate child views from inside it
    mDrawerListView = (ListView) view.findViewById(R.id.nav_listView);
    mDrawerImage = (ImageView) view.findViewById(R.id.nav_image);
    mDrawerText = (TextView) view.findViewById(R.id.nav_text);

    // configure the Views
    mDrawerText.setText("Give it a name/title");
    //mDrawerImage.setImageURI(...);    // set your ImageView however you want, I just gave it one in XML
    mDrawerListView.setOnItemClickListener(this);
    mDrawerListView.setAdapter(new ArrayAdapter<String>(getActionBar().getThemedContext(),
            android.R.layout.simple_list_item_1, android.R.id.text1, siteNames));
    mDrawerListView.setItemChecked(mCurrentSelectedPosition, true);

    // and return the inflated view up the stack
    return view;
}