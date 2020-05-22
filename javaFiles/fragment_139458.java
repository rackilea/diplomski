public class MainFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        // Inflate the layout for this fragment
        Button breedButton = (Button) v.findViewById(R.id.pokemon_breeding_button);

        breedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment, new BreedingFragment());
                transaction.addToBackStack("tag");
                transaction.commit();
            }
        });
        return v;
    }
}