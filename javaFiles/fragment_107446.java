@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                         @Nullable Bundle savedInstanceState) {

    View root = inflater.inflate(R.layout.fragment_first_page_expense_details, container, false);

    ....

    //Observe things and update data accordingly 
    viewModel.getThings().observe(this, new Observer<List<ThingEntity>>() {
        // I wonder if the progress bar value could be passed here to call my repository
        @Override
        public void onChanged(List<ThingEntity> thingEntities) {

            //check null here and skip
            if(thingEntities != null) {
                for (ThingEntity thing : thingEntities) {
                    totalSum[0] = totalSum[0] + thing.getThingAmount();
                }
                textViewTotalSum.setText(String.valueOf(totalSum[0]));
                adapter.setThingEntityList(thingEntities);
                setThingEntities(thingEntities);
            }
        }
    });

    //Initially call with default min 0
    viewModel.getAllThings(0);

    return root;
}