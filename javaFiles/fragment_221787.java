@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {
List<Result> result = new Gson().fromJson(getArguments().getString("valuesArray"), 
new TypeToken<List<Result>>(){}.getType());   
return inflater.inflate(R.layout.fragment, container, false);
}