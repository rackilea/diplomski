public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";

    //Vars
    private ArrayList<String> mImage = new ArrayList<>();
    private ArrayList<String> mTitle = new ArrayList<>();
    private ArrayList<String> mDesc = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // initialize container view
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // pass container view to bitmap images so that will use to initialize recyclerView
        initBitmapImages(view);

        return view;
    }



    private void initBitmapImages(View view){
        Log.d(TAG, "initBitmapImages: preparing bitmaps");

        mImage.add("https://i.redd.it/j6myfqglup501.jpg");
        mTitle.add("Foto 1");
        mDesc.add("This is foto 1");

        mImage.add("https://i.redd.it/j6myfqglup501.jpg");
        mTitle.add("Foto 2");
        mDesc.add("This is foto 2");

        mImage.add("https://i.redd.it/j6myfqglup501.jpg");
        mTitle.add("Foto 3");
        mDesc.add("This is foto 3");

        mImage.add("https://i.redd.it/j6myfqglup501.jpg");
        mTitle.add("Foto 4");
        mDesc.add("This is foto 4");

        mImage.add("https://i.redd.it/j6myfqglup501.jpg");
        mTitle.add("Foto 5");
        mDesc.add("This is foto 5");

        mImage.add("https://i.redd.it/j6myfqglup501.jpg");
        mTitle.add("Foto 6");
        mDesc.add("This is foto 6");

        mImage.add("https://i.redd.it/j6myfqglup501.jpg");
        mTitle.add("Foto 7");
        mDesc.add("This is foto 7");

        mImage.add("https://i.redd.it/j6myfqglup501.jpg");
        mTitle.add("Foto 8");
        mDesc.add("This is foto 8");

        // container view uses to initialize recycle view
        initRecyclerView(view);
    }
    private void initRecyclerView(View view){
        Log.d(TAG, "initRecyclerView: init recyclerView");

        // Initialize recycle view which exist in parent container view so it found and initialize 
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mImage,mTitle,mDesc,getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}