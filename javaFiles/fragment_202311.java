for(int x = 0; x < runs.size(); x++){

    inflater = getLayoutInflater();
    View layout = inflater.inflate(R.layout.run_layout, (ViewGroup) getCurrentFocus());

    TextView name = (TextView) layout.findViewById(R.id.tvRunName);
    name.setText(runs.get(x).getName());

    llRuns.addView(layout);
}