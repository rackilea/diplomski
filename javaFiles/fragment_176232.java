@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        EditText search = (EditText)view.findViewById(R.id.search_view);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String inserted = s.toString();
                for(int i=0; i< city_list.size();i++){
                    if(city_list.get(i).toString().equalsIgnoreCase(inserted)){
                        TextView id = (TextView) view .findViewById(R.id.city_id);
                        id.setText(city_list.get(i).get("_id").toString());
                        TextView lat = (TextView) view .findViewById(R.id.city_lat);
                        lat.setText(city_list.get(i).get("lat").toString());
                        TextView lon = (TextView) view .findViewById(R.id.city_long);
                        lon.setText(city_list.get(i).get("lon").toString());
                    }
                }
            }
        });


        return view;
    }