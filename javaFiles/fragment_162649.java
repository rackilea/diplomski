ListView listView;//globally
TextView tv;


     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myFragmentView = inflater.inflate(R.layout.fragment_fourth, container, false);

  listView = (ListView) tv.findViewById(R.id.customListView);
        //create our property elements
        weatherProperties.add(new Weather(10, "Smith Street", "Sydney", "NSW", "A large 3 bedroom apartment right in the heart of Sydney! A rare find, with 3 bedrooms and a secured car park.", 450.00, "property_image_1", 3, 1, 1));
        weatherProperties.add(new Weather(66, "King Street", "Sydney", "NSW", "A fully furnished studio apartment overlooking the harbour. Minutes from the CBD and next to transport, this is a perfect set-up for city living.", 320.00, "property_image_2", 1, 1, 1));
        weatherProperties.add(new Weather(1, "Liverpool Road", "Liverpool", "NSW", "A standard 3 bedroom house in the suburbs. With room for several cars and right next to shops this is perfect for new families.", 360.00, "property_image_3", 3, 2, 2));
        weatherProperties.add(new Weather(567, "Sunny Street", "Gold Coast", "QLD", "Come and see this amazing studio apartment in the heart of the gold coast, featuring stunning waterfront views.", 360.00, "property_image_4" , 1, 1, 1));

         tv = (TextView) myFragmentView.findViewById(R.id.bedroom);
        tv.setText("My Header");
//        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,names));
        // New Array Adapters
        ArrayAdapter<Weather> adapter = new weatherArrayAdapter(getContext(), 0, weatherProperties);
        //Find list view and bind it with the custom adapter

        listView.setAdapter(adapter);


        return myFragmentView;
    }