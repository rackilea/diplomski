public class Category extends Fragment implements View.OnClickListener {

CategoryAdapter catAdpater;
FragmentController controller;
FragmentCommunicator communicator;

ArrayList<Integer> catImages = new ArrayList<>();
GridView catGrid;
String[] gridItem = {
        "Technology",
        "Food & Drink",
        "Catering",
        "Education",
        "Travel",
        "Accessories",
        "Cleaners",
        "Cloth",
        "Random"
};

String[] gridColor = {
        "#3c6169",
        "#30515d",
        "#284b5e",
        "#224156",
        "#86a6a1",
        "#729493",
        "#3c6169",
        "#30515d",
        "#224156",
        "#3c6169"
};


LinearLayout categoryLayout;
ImageView back;


public Category() {
    // Required empty public constructor
}


@Override
public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                         final Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_category, container, false);
    //controller = new FragmentController();
    //communicator = (FragmentCommunicator)getActivity();



    //MrVector.inflate(getResources(), R.drawable.phone);
    catGrid = (GridView)view.findViewById(R.id.catGrid);
    categoryLayout = (LinearLayout)view.findViewById(R.id.header);
    back =(ImageView)view.findViewById(R.id.back);
    categoryLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //empty
        }
    });
    back.setOnClickListener(this);

    ArrayList<String> categories = new ArrayList<>();
    categories.add("Technology");
    categories.add("Food & Drink");
    categories.add("Catering");
    categories.add("Education");
    categories.add("Travel");
    categories.add("Accessories");
    categories.add("Cleaners");
    categories.add("Cloth");
    categories.add("Random");


    catImages.add(R.drawable.ic_phone_iphone_white_48dp);
    catImages.add(R.drawable.ic_local_drink_white_48dp);
    catImages.add(R.drawable.ic_restaurant_white_48dp);
    catImages.add(R.drawable.ic_school_white_48dp);
    catImages.add(R.drawable.ic_airplanemode_active_white_48dp);
    catImages.add(R.drawable.ic_watch_white_48dp);
    catImages.add(R.drawable.ic_phone_iphone_white_48dp);
    catImages.add(R.drawable.ic_action_accessibility);
    catImages.add(R.drawable.ic_store_mall_directory_white_48dp);

    catAdpater = new CategoryAdapter(this.getContext(),categories,catImages,gridColor);
    catGrid.setAdapter(catAdpater); }