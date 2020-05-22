public class HomeFragment extends Fragment {

    public static final String TITLE = "Accueil";
    private RecyclerView myRecycler;
    private LastOffersRecyclerAdapter listAdapter;
    private ArrayList<OfferItem> dataList;

    public static HomeFragment newInstance() {
        return new HomeFragment ();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        createSampleData();
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        listAdapter = new LastOffersRecyclerAdapter(getContext(),dataList);
        myRecycler  = rootView.findViewById(R.id.my_list_recycler);
        myRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        myRecycler.setItemAnimator(new DefaultItemAnimator());
        myRecycler.setAdapter(listAdapter);



        return  rootView;
    }

    private void createSampleData(){
        dataList = new ArrayList<OfferItem>();
        OfferItem itm;

        for(int i =0 ;i<10 ; i++){
            itm = new OfferItem(i,"business_logo.png","offer_img.png","La Piscope","Fes");
            dataList.add(itm);
        }

    }

}