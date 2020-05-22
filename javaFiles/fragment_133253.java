@Override
public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    sharedViewModel = new ViewModelProvider(requireActivity()).
            get(SharedViewModel.class); //gets the shared view model from the associsated fragment.
    MutableLiveData<String> tableColor = sharedViewModel.getColor();
    tableColor.observe(this, new Observer<String>() {
        @Override
        public void onChanged(String s) {
            Toast.makeText(getActivity(), "IF I GET HERE TWICE I DIE", Toast.LENGTH_SHORT).show();
        }

    });
}