@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                     Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v= inflater.inflate(R.layout.fragment_message, container, false);
    recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);

    // your code

    listSuperHeroes = new ArrayList<>();
    adapter = new CardAdapter(listSuperHeroes, getActivity());

    // Set adapter here so you don't get warning.
    recyclerView.setAdapter(adapter);

    // your code

    return v;
}