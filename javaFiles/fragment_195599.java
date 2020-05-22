public Dialog onCreateDialog(Bundle savedInstanceState) {
        inflater = getActivity().getLayoutInflater();
        v = inflater.inflate(R.layout.call, null);
        Button annuleren = (Button) v.findViewById(R.id.annuleren); //here is the problem I assume
        annuleren.setOnClickListener(this);


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v);
        return builder.create();
    }