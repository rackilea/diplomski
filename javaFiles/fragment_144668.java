public class FragmentBookmark extends Fragment {


    public FragmentBookmark() {
        // Required empty public constructor
    }

    private Context mContext;
    ArrayList<Bookmark> arrayList = new ArrayList<>();
    XmlPullParserFactory pullParserFactory;

    RecyclerView myRecyclerView;
    DataAdapter dataAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_bookmark, container, false);

        myRecyclerView = rootView.findViewById(R.id.myRecyclerView);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        myRecyclerView.setHasFixedSize(true);

        dataAdapter = new DataAdapter(mContext, arrayList);
        myRecyclerView.setAdapter(dataAdapter);

        try {

            XmlPullParser xpp = getResources().getXml(R.xml.bookmarks);

            while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
                if (xpp.getEventType() == XmlPullParser.START_TAG) {
                    if (xpp.getName().equals("Bookmark")) {

                        Log.e("MY_VALUE", " * " + xpp.getAttributeValue(0) + " * ");
                        Log.e("MY_VALUE", " * " + xpp.getAttributeValue(1) + " * ");
                        Log.e("MY_VALUE", " * " + xpp.getAttributeValue(5) + " * ");
                        Log.e("MY_VALUE", " * " + xpp.getAttributeValue(2) + " * ");
                        Log.e("MY_VALUE", " * " + xpp.getAttributeValue(3) + " * ");
                        Log.e("MY_VALUE", " * " + xpp.getAttributeValue(4) + " * ");


                        Bookmark bookmark = new Bookmark();
                        bookmark.setName(xpp.getAttributeValue(0));

                        int drawableResourceId = this.getResources().getIdentifier(xpp.getAttributeValue(1), "drawable", mContext.getPackageName());
                        bookmark.setIcon(drawableResourceId);

                        bookmark.setId(xpp.getAttributeValue(2));

                        bookmark.setSearchUrl(xpp.getAttributeValue(3));
                        bookmark.setNativeUrl(xpp.getAttributeValue(4));
                        arrayList.add(bookmark);

                    }
                }

                xpp.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataAdapter.notifyDataSetChanged();
        return rootView;
    }

}