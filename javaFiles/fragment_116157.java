@Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            List<ItemObject> myList = new ArrayList<ItemObject>();
            rcAdapter = new RecyclerViewAdapter(getActivity(), myList);
        }